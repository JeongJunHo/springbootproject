package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.NoticeDTO;
import com.ssafy.safefood.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeRepository repo;
	
	@Override
	public int insert(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.insert(dto);
	}

	@Override
	public int delete(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.delete(dto);
	}

	@Override
	public int update(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.update(dto);
	}

	@Override
	public int updateRead(NoticeDTO dto) {
		// TODO Auto-generated method stub
		dto.setRead(1);
		return repo.updateRead(dto);
	}

	@Override
	public NoticeDTO selectOne(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectOne(dto);
	}

	@Override
	public List<NoticeDTO> selectList(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectList(dto);
	}

	@Override
	public List<NoticeDTO> selectListUnread(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectListUnread(dto);
	}

	@Override
	public List<NoticeDTO> selectListAll() {
		// TODO Auto-generated method stub
		return repo.selectListAll();
	}

}
