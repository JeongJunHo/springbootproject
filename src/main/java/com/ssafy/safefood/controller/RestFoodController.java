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

import com.ssafy.safefood.dto.FoodDTO;
import com.ssafy.safefood.service.FoodService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController
@RequestMapping("/api/food")
public class RestFoodController {
	@Autowired FoodService foodService;
	
	@GetMapping("/list")
	@ApiOperation(value="product 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> productList() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<FoodDTO> list = foodService.searchAll(null, null);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/searchbestindex")
	@ApiOperation(value="searchBestIndex 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> searchBestIndex() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<FoodDTO> list = foodService.searchBestIndex();
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/bestfoodlist")
	@ApiOperation(value="bestproduct 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> productBestList() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<FoodDTO> list = foodService.searchBest();
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}

	@GetMapping("/safecombinationList/{searchCalory}/{id}")
	@ApiOperation(value="safecombinationList 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> safecombinationList(@PathVariable("searchCalory")String searchCalory,@PathVariable("id")String id) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {			
			Integer maxCalory = 0;
			if (searchCalory != null && searchCalory != "") {
				maxCalory = Integer.parseInt(searchCalory);
			}
			List<List<FoodDTO>> llist = foodService.combinationSearch(maxCalory, id);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", llist);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}

	@GetMapping("/materialusechart")
	@ApiOperation(value="bestproduct 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> materialusechart() {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			HashMap<String, Integer> map = foodService.materialAccumulator();
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", map);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/allergyfood/{id}")
	@ApiOperation(value="bestproduct 조회 서비스", response=List.class)
	public ResponseEntity<Map<String,Object>> allergyFood(@PathVariable("id")String id) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			HashMap<String, List<FoodDTO>> map = foodService.allergyFood(id);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", map);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@GetMapping("/view/{code}")
	@ApiOperation(value="코드로 상품 1개 조회", response=FoodDTO.class)
	public ResponseEntity<Map<String,Object>> productView(@PathVariable("code")String code) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			FoodDTO product = foodService.search(Integer.parseInt(code), null);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", product);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	@GetMapping("/view_id/{code}/{id}")
	@ApiOperation(value="코드로 상품 1개 조회", response=FoodDTO.class)
	public ResponseEntity<Map<String,Object>> productView_id(@PathVariable("code")String code,@PathVariable("id")String id) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			FoodDTO product = foodService.search(Integer.parseInt(code),id);
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 성공");
			msg.put("resvalue", product);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
}
