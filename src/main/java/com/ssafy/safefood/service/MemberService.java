package com.ssafy.safefood.service;

import java.util.List;
import java.util.Map;

import com.ssafy.safefood.dto.MemberDTO;
 


public interface MemberService {
	public int insert(String id, String pw, String name, String addr, String tel, String allergy);
	public int update(String id, String pw, String name, String addr, String tel, String allergy);
	public int delete(String id,String pw);
	public String find_id(String name,String addr);
	public String find_pw(String id, String addr);   
	public MemberDTO selectOne(String m);
	public List<MemberDTO> selectList();
	public Map<String,Integer> allUserAllergy();
} 
 