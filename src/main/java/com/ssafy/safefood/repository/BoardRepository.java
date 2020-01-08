package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.BoardDTO;

public interface BoardRepository {
	public int insert(BoardDTO m);
	public int delete(BoardDTO m);
	public int update(BoardDTO m);
	public List<BoardDTO> selectList();
	public List<BoardDTO> selectListSearchTitle(BoardDTO m);
	public BoardDTO selectOne(BoardDTO m);
}
