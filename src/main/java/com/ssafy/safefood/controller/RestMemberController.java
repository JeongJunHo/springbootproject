
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

import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.service.MemberService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController	//리퀘스트바디 리스폰스바디를 안써도됨
@RequestMapping("/api/member")
public class RestMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);

	@Autowired
	MemberService ser;
	

	@PostMapping("/insert")
	@ApiOperation(value="member 등록 서비스")
	public ResponseEntity<Map> memRegPage(@RequestBody MemberDTO dto)  {
		ResponseEntity<Map> resEntity=null;
		
		try {
			int insert = ser.insert(dto.getId(),dto.getPw(),dto.getName(),dto.getAddr(),dto.getTel(),dto.getAllergy());
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
	
//	제이슨 방식으로 넣기
//	{
//		"num" 	: "999",
//		"pw"	: "999",
//		"name"	: "홍길동",
//		"tel"	: "0990"
//	}

	
	
	@GetMapping("/list")
	@ApiOperation(value="member 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String,Object>> memList() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<MemberDTO> list=null;
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
	@ApiOperation(value="num을 받아 member 조회 서비스", response=MemberDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("num")String id) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		MemberDTO mem = null;
		try {

			mem = ser.selectOne(id);

			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",mem);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}

	
	@DeleteMapping("/delete/{id}/{pw}")
	@ApiOperation(value="num을 받아 member 삭제 서비스")
	public ResponseEntity<Map<String,Object>> memDelete(@PathVariable("id")String id,@PathVariable("pw")String pw) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int delete = ser.delete(id,pw);
			Map<String, Object> map = new HashMap();
			if(delete>0) {
				map.put("resmsg","삭제성공");
			}
			else {
				map.put("resmsg","삭제실패");
			}
			map.put("resvalue",delete);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "삭제실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}
		return resEntity; 
	}

	@GetMapping("/find_id/{name}/{addr}")
	@ApiOperation(value="id,tel을 받아 비밀번호 찾기 서비스")
	public ResponseEntity<Map<String,Object>> memFindId(@PathVariable("name")String name,@PathVariable("addr")String addr) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			String res = ser.find_id(name, addr);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","ok");
			map.put("resvalue",res);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}
		return resEntity;
	}

	@PutMapping("/find_pw/{id}/{addr}")
	@ApiOperation(value="id,tel을 받아 비밀번호 찾기 서비스")
	public ResponseEntity<Map<String,Object>> memFindPw(@PathVariable("id")String id,@PathVariable("addr")String addr) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			String res = ser.find_pw(id, addr);
			Map<String, Object> map = new HashMap();
			map.put("resmsg","ok");
			map.put("resvalue",res);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}
		return resEntity;
	}

	
	@PutMapping("/update")
	@ApiOperation(value="Member을 받아 member 수정 서비스")
	public ResponseEntity<Map<String,Object>> memUpdate(@RequestBody MemberDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			int update = ser.update(dto.getId(),dto.getPw(),dto.getName(),dto.getAddr(),dto.getTel(),dto.getAllergy());
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
	
	@GetMapping("/allUserAllergy")
	@ApiOperation(value="모든 맴버의 알러지별 빈도 수")
	public ResponseEntity<Map<String,Object>> allUserAllergy(){
		ResponseEntity<Map<String, Object>> resEntity = null;

		try {
			Map<String, Integer> allUserAllergy = ser.allUserAllergy();
			Map<String, Object> map = new HashMap();
			map.put("resmsg","조회성공");
			map.put("resvalue",allUserAllergy);
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(RuntimeException e){
			Map<String, Object> map = new HashMap();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		return resEntity;
	}
}
