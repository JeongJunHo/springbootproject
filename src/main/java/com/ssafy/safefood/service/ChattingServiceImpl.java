package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.ChattingDTO;
import com.ssafy.safefood.repository.ChattingRepository;

@Service
public class ChattingServiceImpl implements ChattingService{
	
	@Autowired
	ChattingRepository repo;

	@Override
	public int insert(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return repo.insert(dto);
	}

	@Override
	public int delete(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return repo.delete(dto);
	}

	@Override
	public int update(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return repo.update(dto);
	}

	@Override
	public List<ChattingDTO> selectList() {
		// TODO Auto-generated method stub
		return repo.selectList();
	}

	@Override
	public List<ChattingDTO> selectList_id(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectList_id(dto);
	}

	@Override
	public ChattingDTO selectOne(ChattingDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectOne(dto);
	}
	
}
