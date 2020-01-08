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

import com.ssafy.safefood.dto.NoticeDTO;
import com.ssafy.safefood.service.NoticeService;

import io.swagger.annotations.ApiOperation;

//나중에 컨트롤러 위에꺼 써줘
@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController	//리퀘스트바디 리스폰스바디를 안써도됨
@RequestMapping("/api/notice")
public class RestNoticeController {
	
	@Autowired
	NoticeService ser;
	
	@PostMapping("/insert")
	@ApiOperation(value="쪽지 등록 서비스")
	public ResponseEntity<Map> insert(@RequestBody NoticeDTO dto)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = ser.insert(dto);
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
	
	@DeleteMapping("/delete/{num}")
	@ApiOperation(value="num을 받아 알림 삭제 서비스")
	public ResponseEntity<Map<String,Object>> delete(@PathVariable("num")String anum) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			NoticeDTO dto = new NoticeDTO();
			dto.setNum(Integer.parseInt(anum));
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
	@ApiOperation(value="쪽지 수정 서비스")
	public ResponseEntity<Map<String,Object>> update(@RequestBody NoticeDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = ser.update(dto);
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

	@PutMapping("/updateRead")
	@ApiOperation(value="쪽지 수정 서비스")
	public ResponseEntity<Map<String,Object>> updateRead(@RequestBody NoticeDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = ser.updateRead(dto);
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

	@GetMapping("/selectOne/{num}")
	@ApiOperation(value="쪽지 조회")
	public @ResponseBody ResponseEntity<Map<String,Object>> selectOne(@PathVariable("num")String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			NoticeDTO dto = new NoticeDTO();
			dto.setNum(Integer.parseInt(num));
			NoticeDTO result = ser.selectOne(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",result);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/selectList/{id}")
	@ApiOperation(value="쪽지 조회")
	public @ResponseBody ResponseEntity<Map<String,Object>> selectList(@PathVariable("id")String id) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			NoticeDTO dto = new NoticeDTO();
			dto.setId(id);
			List<NoticeDTO> selectList = ser.selectList(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",selectList);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/selectListUnread/{id}")
	@ApiOperation(value="쪽지 조회")
	public @ResponseBody ResponseEntity<Map<String,Object>> selectListUnread(@PathVariable("id")String id) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			NoticeDTO dto = new NoticeDTO();
			dto.setId(id);
			List<NoticeDTO> selectList = ser.selectListUnread(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",selectList);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/selectListAll")
	@ApiOperation(value="쪽지 조회")
	public @ResponseBody ResponseEntity<Map<String,Object>> selectListAll() {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			List<NoticeDTO> selectList = ser.selectListAll();
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",selectList);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

}
