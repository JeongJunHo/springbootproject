package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.MemberDTO;

public interface MemberRepository {
	public int insert(MemberDTO m);
	public int update(MemberDTO m);
	public int delete(String m);
	public MemberDTO selectOne(String m);
	public MemberDTO selectOne_name_addr(MemberDTO m);
	public List<MemberDTO> selectList();
}
