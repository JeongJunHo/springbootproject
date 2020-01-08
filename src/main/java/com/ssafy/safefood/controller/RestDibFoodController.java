
package com.ssafy.safefood.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.safefood.dto.DibFoodDTO;
import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.service.DibFoodService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController	//리퀘스트바디 리스폰스바디를 안써도됨
@RequestMapping("/api/dibfood")
public class RestDibFoodController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestDibFoodController.class);

	@Autowired
	DibFoodService ser;
	

	@PostMapping("/insert")	//전에는 takefood였음
	@ApiOperation(value="dibfood 등록 서비스")
	public ResponseEntity<Map> memRegPage(@RequestBody DibFoodDTO dto)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = ser.insert(dto);
			//String msg = insert+" 입력했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "입력했습니다");
			msg.put("resvalue", insert);
			
			resEntity = new ResponseEntity<Map>(msg,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "입력실패");
			resEntity = new ResponseEntity<Map>(msg,HttpStatus.OK);
		}
		return resEntity;
	}
	
	@PostMapping("/addlist")	//전에는 takefood였음
	@ApiOperation(value="dibfood 등록 서비스")
	public ResponseEntity<Map> addList(@RequestBody DibFoodDTO dto)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = ser.addList(dto);
			//String msg = insert+" 입력했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "입력했습니다");
			msg.put("resvalue", insert);
			
			resEntity = new ResponseEntity<Map>(msg,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> msg = new HashMap();
			msg.put("resmsg", "입력실패");
			resEntity = new ResponseEntity<Map>(msg,HttpStatus.OK);
		}
		return resEntity;
	}
	
	

	@GetMapping("/list/{id}")	//전에는 searchall였음
	@ApiOperation(value="id를 받아 dibfood 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> dibfoodView(@PathVariable("id")String id) {
		
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<DibFoodDTO> list=null;
		DibFoodDTO dto = new DibFoodDTO();
		try {
			dto.setId(id);
			System.out.println("id???"+id);
			list = ser.selectList_id(dto);
			System.out.println("id222"+id);
			
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",list);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);

		}
		return resEntity;
	}
	
	
	@GetMapping("/view/{id}/{code}")
	@ApiOperation(value="id와 code를 받아 dibfood 조회 서비스", response=DibFoodDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("id")String id,@PathVariable("code")String code) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		DibFoodDTO dibfood = null;
		try {
			DibFoodDTO dto = new DibFoodDTO();
			dto.setId(id);
			dto.setCode(Integer.parseInt(code));
			dibfood = ser.selectOne(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",dibfood);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

	@DeleteMapping("/delete/{id}/{code}")
	@ApiOperation(value="id와 code를 받아 dibfood 삭제 서비스")
	public ResponseEntity<Map<String,Object>> memDelete(@PathVariable("id")String id,@PathVariable("code")String code) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			DibFoodDTO dto = new DibFoodDTO();
			dto.setId(id);
			dto.setCode(Integer.parseInt(code));
			int delete = ser.delete(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","삭제성공");
			map.put("resvalue",delete);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}
		return resEntity;
	}
	
	@PutMapping("/update")
	@ApiOperation(value="dibfood를 받아 dibfood 수정 서비스")
	public ResponseEntity<Map<String,Object>> memUpdate(@RequestBody DibFoodDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = ser.update(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","수정성공");
			map.put("resvalue",update);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
	
	@GetMapping("/TodayDibPlusEatSumList/{id}")
	@ApiOperation(value="당일 섭취량에 찜 목록을 섭취했을 때의 변화량 반환", response=Map.class)
	public ResponseEntity<Map<String,Object>> todayDibPlusEatSumList(@PathVariable("id")String id){
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			Map<String, Object> res = ser.selectTodayDibPlusEatSumList(id);
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
