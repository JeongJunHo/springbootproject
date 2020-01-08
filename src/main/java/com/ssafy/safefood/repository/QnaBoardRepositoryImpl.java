package com.ssafy.safefood.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.BoardDTO;
import com.ssafy.safefood.dto.QnaBoardDTO;

@Repository("QnaBoardRepositoryImpl")
public class QnaBoardRepositoryImpl implements QnaBoardRepository {
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(QnaBoardDTO qnaBoardDTO) {
		return session.insert("safefood.qnaBoard.insert", qnaBoardDTO);
	}

	@Override
	public int delete(int qnum) {
		return session.delete("safefood.qnaBoard.delete", qnum);
	}

	@Override
	public int update(QnaBoardDTO qnaBoardDTO) {
		return session.update("safefood.qnaBoard.update", qnaBoardDTO);
	}

	@Override
	public QnaBoardDTO selectOne(int qnum) {
		return session.selectOne("safefood.qnaBoard.selectOne", qnum);
	}

	@Override
	public int updateHit(int qnum, int hit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qnum", qnum);
		map.put("hit", hit);
		return session.update("safefood.qnaBoard.updateHit", map);
	}

	@Override
	public List<QnaBoardDTO> selectList() {
		return session.selectList("safefood.qnaBoard.selectList");
	}

	@Override
	public List<QnaBoardDTO> selectList_search(String searchType, String searchText) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		return session.selectList("safefood.qnaBoard.selectList_search", map);
	}
}
