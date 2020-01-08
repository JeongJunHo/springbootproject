package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.NoticeDTO;

public interface NoticeService {
	public int insert(NoticeDTO dto);
	public int delete(NoticeDTO dto);
	public int update(NoticeDTO dto);
	public int updateRead(NoticeDTO dto);
	public NoticeDTO selectOne(NoticeDTO dto);
	public List<NoticeDTO> selectList(NoticeDTO dto);
	public List<NoticeDTO> selectListUnread(NoticeDTO dto);
	public List<NoticeDTO> selectListAll();
}
