package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.MemberDTO;



@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {

	@Autowired
	SqlSession session;
	
	@Override
	public int insert(MemberDTO m)  {
		// TODO Auto-generated method stub
		System.out.println("repo");
		System.out.println(m.toString());
		int insert = session.insert("safefood.member.insert",m);
		System.out.println("repo2");
		
		return insert;
		
	}

	@Override
	public int update(MemberDTO m) {
		// TODO Auto-generated method stub
		int update = session.update("safefood.member.update",m);
		return update;
	}

	@Override
	public int delete(String m) {
		// TODO Auto-generated method stub
		int delete = session.delete("safefood.member.delete",m);
		return delete;
	}

	@Override
	public MemberDTO selectOne(String m) {
		// TODO Auto-generated method stub
		MemberDTO selectOne = session.selectOne("safefood.member.selectOne",m);
		return selectOne;
	}

	@Override
	public List<MemberDTO> selectList() {
		// TODO Auto-generated method stub
		List<MemberDTO> selectList = session.selectList("safefood.member.selectList");
		return selectList;
	}

	@Override
	public MemberDTO selectOne_name_addr(MemberDTO m) {
		// TODO Auto-generated method stub
		MemberDTO selectOne = session.selectOne("safefood.member.selectOne_name_addr",m);
		return selectOne;
	}

}
