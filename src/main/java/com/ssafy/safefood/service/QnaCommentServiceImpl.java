package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.QnaCommentDTO;
import com.ssafy.safefood.repository.QnaCommentRepository;

@Service
public class QnaCommentServiceImpl implements QnaCommentService {
	
	@Autowired
	QnaCommentRepository rep;

	@Override
	public int insert(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return rep.insert(dto);
	}

	@Override
	public int delete(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return rep.delete(dto);
	}

	@Override
	public int update(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return rep.update(dto);
	}

	@Override
	public List<QnaCommentDTO> selectList(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return rep.selectList(dto);
	}

	@Override
	public List<QnaCommentDTO> selectListAll() {
		// TODO Auto-generated method stub
		return rep.selectListAll();
	}
	
	
}
