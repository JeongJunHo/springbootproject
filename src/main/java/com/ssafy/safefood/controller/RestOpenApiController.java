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

import com.ssafy.safefood.service.OpenApiService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RequestMapping("/api/11stopenapi")
@RestController
public class RestOpenApiController {
	@Autowired OpenApiService openApiService;
	
	@GetMapping("search/{name}")
	@ApiOperation(value="11번가 상품 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> shoppingInfo(@PathVariable("name")String name) throws SAXException, IOException, ParserConfigurationException {
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> msg = new HashMap<String,Object>();
		try {
//			System.out.println(URLEncoder.encode(name, "UTF-8"));
			
			List<HashMap<String, Object>> res = openApiService.shoppingInfo(URLEncoder.encode(name, "UTF-8"));
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
