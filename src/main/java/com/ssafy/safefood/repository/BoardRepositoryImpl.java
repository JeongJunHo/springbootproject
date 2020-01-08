package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.BoardDTO;

@Repository("BoardRepositoryImpl")
public class BoardRepositoryImpl implements BoardRepository {

	@Autowired
	SqlSession session;
	
	@Override
	public int insert(BoardDTO m)  {
		// TODO Auto-generated method stub
		int insert = session.insert("safefood.board.insert",m);
		return insert;
		
	}

	@Override
	public int update(BoardDTO m) {
		// TODO Auto-generated method stub
		int update = session.update("safefood.board.update",m);
		return update;
	}

	@Override
	public int delete(BoardDTO m) {
		// TODO Auto-generated method stub
		int delete = session.delete("safefood.board.delete",m);
		return delete;
	}

	@Override
	public List<BoardDTO> selectList() {
		// TODO Auto-generated method stub
		List<BoardDTO> selectList = session.selectList("safefood.board.selectList");
		return selectList;
	}

	@Override
	public List<BoardDTO> selectListSearchTitle(BoardDTO m) {
		// TODO Auto-generated method stub
		List<BoardDTO> selectList = session.selectList("safefood.board.selectListSearchTitle",m);
		return selectList;
	}
	
	@Override
	public BoardDTO selectOne(BoardDTO m) {
		// TODO Auto-generated method stub
		BoardDTO selectOne = session.selectOne("safefood.board.selectOne",m);
		return selectOne;
	}



}
