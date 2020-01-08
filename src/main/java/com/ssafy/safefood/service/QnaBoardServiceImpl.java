package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.QnaBoardDTO;
import com.ssafy.safefood.repository.QnaBoardRepository;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {
	@Autowired QnaBoardRepository qnaBoardRepository;

	@Override
	public int insert(QnaBoardDTO qnaBoardDTO) {
		return qnaBoardRepository.insert(qnaBoardDTO);
	}

	@Override
	public int delete(int qnum) {
		return qnaBoardRepository.delete(qnum);
	}

	@Override
	public int update(QnaBoardDTO qnaBoardDTO) {
		return qnaBoardRepository.update(qnaBoardDTO);
	}

	@Override
	public int updateHit(int qnum, int hit) {
		return qnaBoardRepository.updateHit(qnum, hit);
	}

	@Override
	public QnaBoardDTO selectOne(int qnum) {
		QnaBoardDTO qnaboardDTO = qnaBoardRepository.selectOne(qnum);
		qnaboardDTO.setHit(qnaboardDTO.getHit()+1);
		qnaBoardRepository.updateHit(qnum, qnaboardDTO.getHit());
		return qnaboardDTO;
	}

	@Override
	public List<QnaBoardDTO> selectList() {
		return qnaBoardRepository.selectList();
	}

	@Override
	public List<QnaBoardDTO> selectList_search(String searchType, String searchText) {
		return qnaBoardRepository.selectList_search(searchType, searchText);
	}
	
}
