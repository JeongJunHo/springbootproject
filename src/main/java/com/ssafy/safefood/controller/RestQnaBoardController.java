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

import com.ssafy.safefood.dto.BoardDTO;
import com.ssafy.safefood.dto.QnaBoardDTO;
import com.ssafy.safefood.service.QnaBoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController
@RequestMapping("/api/qnaboard")
public class RestQnaBoardController {
	private static final Logger logger = LoggerFactory.getLogger(RestQnaBoardController.class);
	
	@Autowired QnaBoardService qnaBoardService;
	
	@PostMapping("/insert")
	@ApiOperation(value="board 등록 서비스")
	public ResponseEntity<Map> insert(@RequestBody QnaBoardDTO qnaBoardDTO)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = qnaBoardService.insert(qnaBoardDTO);
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
	
	@GetMapping("/list/{searchType}/{searchText}")
	@ApiOperation(value="board 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> listSearch(@PathVariable("searchType") String searchType, @PathVariable("searchText") String searchText) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<QnaBoardDTO> list=null;
		try {
			list = qnaBoardService.selectList_search(searchType, searchText);
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
	
	@GetMapping("/list")
	@ApiOperation(value="board 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> list() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<QnaBoardDTO> list=null;
		try {
			list = qnaBoardService.selectList();
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

	
	@GetMapping("/view/{qnum}")
	@ApiOperation(value="num을 받아 board 조회 서비스", response=QnaBoardDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> view(@PathVariable("qnum")String qnum) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		QnaBoardDTO qnaBoard = null;
		try {
			qnaBoard = qnaBoardService.selectOne(Integer.parseInt(qnum));

			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",qnaBoard);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
	@DeleteMapping("/delete/{qnum}")
	@ApiOperation(value="num을 받아 board 삭제 서비스")
	public ResponseEntity<Map<String,Object>> delete(@PathVariable("qnum")String qnum) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int delete = qnaBoardService.delete(Integer.parseInt(qnum));
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
	@ApiOperation(value="board을 받아 board 수정 서비스")
	public ResponseEntity<Map<String,Object>> update(@RequestBody QnaBoardDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = qnaBoardService.update(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","수정성공");
			map.put("resvalue",update);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
}
