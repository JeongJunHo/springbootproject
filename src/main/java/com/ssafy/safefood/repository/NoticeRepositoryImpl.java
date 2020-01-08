package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.NoticeDTO;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

	@Autowired
	SqlSession session;
	
	@Override
	public int insert(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.insert("safefood.notice.insert",dto);
	}

	@Override
	public int delete(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.delete("safefood.notice.delete",dto);
	}

	@Override
	public int update(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.update("safefood.notice.update",dto);
	}

	@Override
	public int updateRead(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.update("safefood.notice.updateRead",dto);
	}

	@Override
	public NoticeDTO selectOne(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.selectOne("safefood.notice.selectOne",dto);
	}

	@Override
	public List<NoticeDTO> selectList(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.selectList("safefood.notice.selectList",dto);
	}

	@Override
	public List<NoticeDTO> selectListUnread(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return session.selectList("safefood.notice.selectListUnread",dto);
	}

	@Override
	public List<NoticeDTO> selectListAll() {
		// TODO Auto-generated method stub
		return session.selectList("safefood.notice.selectListAll");
	}

}
