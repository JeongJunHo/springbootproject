package com.ssafy.safefood.repository;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.DibFoodDTO;


@Repository
public class DidFoodRepositoryImpl implements DibFoodRepository {

	@Autowired
	SqlSession session;

	@Override
	public int insert(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		int insert = session.insert("safefood.dibFood.insert",dto);
		return insert;
	}

	@Override
	public List<DibFoodDTO> selectList_id(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("repo"+dto.getId());
		List<DibFoodDTO> selectList = session.selectList("safefood.dibFood.selectList",dto);
		return selectList;
	}

	@Override
	public int delete(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return session.delete("safefood.dibFood.delete",dto);
	}

	@Override
	public int update(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return session.update("safefood.dibFood.update",dto);
	}

	@Override
	public DibFoodDTO selectOne(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return session.selectOne("safefood.dibFood.selectOne",dto);
	}

	@Override
	public Map<String, Object> selectTodayDibPlusEatSumList(String id) {
		return session.selectOne("safefood.dibFood.selectTodayDibPlusEatSumList", id);
	}



}
