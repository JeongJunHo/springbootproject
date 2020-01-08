package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.BoardDTO;



public interface BoardService {
	public int insert(BoardDTO dto);
	public int update(BoardDTO dto);
	public int delete(BoardDTO dto);
	public BoardDTO selectOne(BoardDTO dto);
	public List<BoardDTO> selectList();
	public List<BoardDTO> selectListSearchTitle(BoardDTO dto);

}
