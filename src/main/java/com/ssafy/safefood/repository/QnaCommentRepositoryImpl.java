package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.QnaCommentDTO;

@Repository
public class QnaCommentRepositoryImpl implements QnaCommentRepository {

	@Autowired
	SqlSession session;

	
	@Override
	public int insert(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return session.insert("safefood.qnacomment.insert",dto);
	}

	@Override
	public int delete(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return session.delete("safefood.qnacomment.delete",dto);
	}

	@Override
	public int update(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return session.update("safefood.qnacomment.update",dto);
	}

	@Override
	public List<QnaCommentDTO> selectList(QnaCommentDTO dto) {
		// TODO Auto-generated method stub
		return session.selectList("safefood.qnacomment.selectList",dto);
	}

	@Override
	public List<QnaCommentDTO> selectListAll() {
		// TODO Auto-generated method stub
		return session.selectList("safefood.qnacomment.selectListAll");
	}

}
