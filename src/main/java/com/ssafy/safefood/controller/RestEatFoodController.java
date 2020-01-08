package com.ssafy.safefood.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.safefood.dto.EatFoodDTO;
import com.ssafy.safefood.dto.EatFoodInfoDTO;
import com.ssafy.safefood.service.EatFoodService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api/eatfood")
public class RestEatFoodController {
	@Autowired EatFoodService eatFoodService;
	
	@PostMapping("/insert")
	@ApiOperation(value="섭취 식품 등록 서비스")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody EatFoodDTO eatFoodDTO) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			int res = eatFoodService.insert(eatFoodDTO);
			msg.put("resmsg", "입력 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "입력 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@PutMapping("/update")
	@ApiOperation(value="섭취 식품 수정 서비스")
	public ResponseEntity<Map<String, Object>> update(@RequestBody EatFoodDTO eatFoodDTO) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			int res = eatFoodService.update(eatFoodDTO);
			msg.put("resmsg", "수정 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "수정 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/delete/{num}")
	@ApiOperation(value="섭취 식품 삭제 서비스")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("num")int num) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			int res = eatFoodService.delete(num);
			msg.put("resmsg", "삭제 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "삭제 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/view/{num}")
	@ApiOperation(value="1개의 섭취 식품 조회 서비스", response=EatFoodDTO.class)
	public ResponseEntity<Map<String, Object>> view(@PathVariable("num")int num) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			EatFoodDTO res = eatFoodService.selectOne(num);
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/list")
	@ApiOperation(value="모든 사용자의 섭취 식품 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> list() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			List<EatFoodInfoDTO> res = eatFoodService.selectList();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/listById/{id}")
	@ApiOperation(value="특정 사용자의 섭취 식품 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> listById(@PathVariable("id")String id) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			List<EatFoodInfoDTO> res = eatFoodService.selectListById(id);
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/totalEatMap/{id}/{sdate}/{edate}")
	@ApiOperation(value="특정 사용자의 지정기간동안 섭취한 영양소 총량", response=Map.class)
	public ResponseEntity<Map<String,Object>> totalEatMap(@PathVariable("id")String id, @PathVariable("sdate")String sdate, @PathVariable("edate")String edate){
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			 Map<String, Object> res = eatFoodService.selectSumListById(id, sdate, edate);
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/dayTotalEatMapList/{id}/{sdate}/{edate}")
	@ApiOperation(value="특정 사용자의 지정기간동안 섭취한 일자별 영양소 총량", response=List.class)
	public ResponseEntity<Map<String,Object>> dayTotalEatMapList(@PathVariable("id")String id, @PathVariable("sdate")String sdate, @PathVariable("edate")String edate){
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> res = eatFoodService.selectDaySumListById(id, sdate, edate);
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/todaySumList/{id}")
	@ApiOperation(value="당일 영양소별 섭취량", response=Map.class)
	public ResponseEntity<Map<String,Object>> todaySumList(@PathVariable("id")String id){
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			Map<String, Object> res = eatFoodService.selectTodaySumList(id);
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", res);
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
}
