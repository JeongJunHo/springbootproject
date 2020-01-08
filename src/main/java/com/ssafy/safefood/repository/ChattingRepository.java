package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.ChattingDTO;


public interface ChattingRepository {
	public int insert(ChattingDTO dto);
	public int delete(ChattingDTO dto);
	public int update(ChattingDTO dto);
	public List<ChattingDTO> selectList();
	public List<ChattingDTO> selectList_id(ChattingDTO dto);
	public ChattingDTO selectOne(ChattingDTO dto);
}
