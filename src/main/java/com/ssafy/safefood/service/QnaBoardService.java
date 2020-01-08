package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.QnaBoardDTO;

public interface QnaBoardService {
	public int insert(QnaBoardDTO qnaBoardDTO);
	public int delete(int qnum);
	public int update(QnaBoardDTO qnaBoardDTO);
	public int updateHit(int qnum, int hit);
	public List<QnaBoardDTO> selectList();
	public List<QnaBoardDTO> selectList_search(String searchType, String searchText);
	public QnaBoardDTO selectOne(int qnum);
}
