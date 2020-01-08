package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.ChattingDTO;

public interface ChattingService {
	
	public int insert(ChattingDTO dto);
	public int delete(ChattingDTO dto);
	public int update(ChattingDTO dto);
	public List<ChattingDTO> selectList();
	public List<ChattingDTO> selectList_id(ChattingDTO dto);
	public ChattingDTO selectOne(ChattingDTO dto);
	
}
