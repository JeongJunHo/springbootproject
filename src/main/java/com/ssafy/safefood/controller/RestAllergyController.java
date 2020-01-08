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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.safefood.dto.AllergyDTO;
import com.ssafy.safefood.service.AllergyService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController
@RequestMapping("/api/allergy")
public class RestAllergyController {
	
	@Autowired
	AllergyService ser;
	
	
	@PostMapping("/insert")
	@ApiOperation(value="allergy 등록 서비스")
	public ResponseEntity<Map> memRegPage(@RequestBody AllergyDTO dto)  {
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

	
	
	@GetMapping("/list")
	@ApiOperation(value="allergy 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> memList() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<AllergyDTO> list=null;
		try {
			list = ser.selectList();
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
	@GetMapping("/view/{num}")
	@ApiOperation(value="num을 받아 member 조회 서비스", response=AllergyDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("num")String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		AllergyDTO allergy = null;
		try {
			AllergyDTO dto = new AllergyDTO();
			dto.setNum(Integer.parseInt(num));
			allergy = ser.selectOne(dto);

			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",allergy);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
	@DeleteMapping("/delete/{num}")
	@ApiOperation(value="num을 받아 allergy 삭제 서비스")
	public ResponseEntity<Map<String,Object>> memDelete(@PathVariable("num")String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			AllergyDTO dto = new AllergyDTO();
			dto.setNum(Integer.parseInt(num));
			
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
	@ApiOperation(value="Member을 받아 member 수정 서비스")
	public ResponseEntity<Map<String,Object>> memUpdate(@RequestBody AllergyDTO dto) {
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
	
	
}
