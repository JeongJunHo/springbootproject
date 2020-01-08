package com.ssafy.safefood.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.ssafy.safefood.service.AllergyService;
import com.ssafy.safefood.service.FoodService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RequestMapping("/api/main")
@RestController
public class RestMainController {
	@Autowired FoodService foodService;
	@Autowired AllergyService allergyService;
	
	@GetMapping("/init")
	@ApiOperation(value="초기화 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> init(){
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
			foodService.loadData();
			allergyService.loadData();
			msg.put("resmsg", "조회 성공");
		}catch (RuntimeException e) {
			msg.put("resmsg", "조회 실패");
		}finally {
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
}
