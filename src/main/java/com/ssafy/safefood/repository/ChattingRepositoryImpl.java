package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.ChattingDTO;

@Repository
public class ChattingRepositoryImpl implements ChattingRepository {
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return session.insert("safefood.chatting.insert",dto);
	}

	@Override
	public int delete(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return session.delete("safefood.chatting.delete",dto);
	}

	@Override
	public int update(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return session.update("safefood.chatting.update",dto);
	}

	@Override
	public List<ChattingDTO> selectList() {
		// TODO Auto-generated method stub
		return session.selectList("safefood.chatting.selectList");
	}

	@Override
	public List<ChattingDTO> selectList_id(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return session.selectList("safefood.chatting.selectList_id",dto);
	}

	@Override
	public ChattingDTO selectOne(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return session.selectOne("safefood.chatting.selectOne",dto);
	}

}
