package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.QnaCommentDTO;

public interface QnaCommentRepository {
	public int insert(QnaCommentDTO dto);
	public int delete(QnaCommentDTO dto);
	public int update(QnaCommentDTO dto);
	public List<QnaCommentDTO> selectList(QnaCommentDTO dto);
	public List<QnaCommentDTO> selectListAll();
}
