
package com.ssafy.safefood.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.BoardDTO;
import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.service.BoardService;
import com.ssafy.safefood.service.MemberService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController	//리퀘스트바디 리스폰스바디를 안써도됨
@RequestMapping("/api/board")
public class RestBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestBoardController.class);

	@Autowired
	BoardService ser;
	

	@PostMapping("/boardreg")
	@ApiOperation(value="board 등록 서비스")
	public ResponseEntity<Map> boardRegPage(@RequestBody BoardDTO dto)  {
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
	
//	제이슨 방식으로 넣기
//	{
//		"num" 	: "999",
//		"pw"	: "999",
//		"name"	: "홍길동",
//		"tel"	: "0990"
//	}

	
	
	@GetMapping("/boardlist")
	@ApiOperation(value="board 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> boardList() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<BoardDTO> list=null;
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

	@GetMapping("/boardlistsearchTitle")
	@ApiOperation(value="board title 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> boardList(@RequestBody BoardDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<BoardDTO> list=null;
		try {
			list = ser.selectListSearchTitle(dto);
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

	
	@GetMapping("/boardview/{num}")
	@ApiOperation(value="num을 받아 board 조회 서비스", response=BoardDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> boardView(@PathVariable("num")String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		BoardDTO board = null;
		try {
			BoardDTO dto = new BoardDTO();
			dto.setNum(Integer.parseInt(num));
			board = ser.selectOne(dto);
			board.setHit(board.getHit()+1);
			ser.update(board);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",board);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
	@DeleteMapping("/boarddelete/{num}")
	@ApiOperation(value="num을 받아 board 삭제 서비스")
	public ResponseEntity<Map<String,Object>> boardDelete(@PathVariable("num")String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			BoardDTO dto = new BoardDTO();
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
	
	@PutMapping("/boardupdate")
	@ApiOperation(value="board을 받아 board 수정 서비스")
	public ResponseEntity<Map<String,Object>> boardUpdate(@RequestBody BoardDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = ser.update(dto);
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
	
}
