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
import com.ssafy.safefood.dto.QnaCommentDTO;
import com.ssafy.safefood.service.QnaCommentService;

import io.swagger.annotations.ApiOperation;

//나중에 컨트롤러 ㄱ
@CrossOrigin(origins= {"*"},maxAge=6000)
@RequestMapping("/api/qnacomment")
@RestController
public class RestQnaCommentController {
	private static final Logger logger = LoggerFactory.getLogger(RestQnaCommentController.class);

	@Autowired
	QnaCommentService qcser;
	
	@PostMapping("/insert")
	@ApiOperation(value="qna코멘트 등록 서비스")
	public ResponseEntity<Map> memRegPage(@RequestBody QnaCommentDTO dto)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = qcser.insert(dto);
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

	@DeleteMapping("/delete/{anum}")
	@ApiOperation(value="num을 받아 qna코멘트 삭제 서비스")
	public ResponseEntity<Map<String,Object>> qcDelete(@PathVariable("anum")String anum) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			QnaCommentDTO dto = new QnaCommentDTO();
			dto.setAnum(Integer.parseInt(anum));
			int delete = qcser.delete(dto);
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
	@ApiOperation(value="qc를 받아 qc 수정 서비스")
	public ResponseEntity<Map<String,Object>> memUpdate(@RequestBody QnaCommentDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = qcser.update(dto);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","수정성공");
			map.put("resvalue",update);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
	
	@GetMapping("/view/{qnum}")
	@ApiOperation(value="qnum을 받아 comment 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("qnum")String qnum) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			QnaCommentDTO dto = new QnaCommentDTO();
			dto.setQnum(Integer.parseInt(qnum));
			List<QnaCommentDTO> list=null;
			Map<String, Object> map = new HashMap();
			list = qcser.selectList(dto);

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
}
