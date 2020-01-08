package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.QnaCommentDTO;

public interface QnaCommentService {
	public int insert(QnaCommentDTO dto);
	public int delete(QnaCommentDTO dto);
	public int update(QnaCommentDTO dto);
	public List<QnaCommentDTO> selectList(QnaCommentDTO dto);
	public List<QnaCommentDTO> selectListAll();
}
