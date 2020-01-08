package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.BoardDTO;
import com.ssafy.safefood.repository.BoardRepository;



@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("BoardRepositoryImpl")
	BoardRepository repo;

	@Override
	public int insert(BoardDTO dto) {
		// TODO Auto-generated method stub

		return repo.insert(dto);
	}

	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
	
		return repo.update(dto);
		
	}

	@Override
	public int delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		return repo.delete(dto);
	}


	@Override
	public List<BoardDTO> selectList() {
		// TODO Auto-generated method stub
		return repo.selectList();
	}

	@Override
	public BoardDTO selectOne(BoardDTO dto) {
		// TODO Auto-generated method stub

		return repo.selectOne(dto);
	}

	@Override
	public List<BoardDTO> selectListSearchTitle(BoardDTO dto) {
		// TODO Auto-generated method stub
	
		return repo.selectListSearchTitle(dto);
	}
	
}
