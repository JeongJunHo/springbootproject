package com.ssafy.safefood.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.FoodDTO;

@Repository
public class FoodRepositoryImpl implements FoodRepository {
	@Autowired
	SqlSession session;

	@Override
	public int insert(FoodDTO foodDTO) {
		return session.insert("safefood.food.insert", foodDTO);
	}

	@Override
	public int updateHit(int code, int hit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("hit", hit);
		return session.update("safefood.food.updateHit", map);
	}

	@Override
	public FoodDTO selectOne(int code) {
		return session.selectOne("safefood.food.selectOne", code);
	}

	@Override
	public List<FoodDTO> selectList(String searchType, String searchText) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		return session.selectList("safefood.food.selectList", map);
	}

	@Override
	public List<FoodDTO> searchBestIndex() {
		return session.selectList("safefood.food.searchBestIndex");
	}

	@Override
	public List<FoodDTO> searchBest() {
		return session.selectList("safefood.food.searchBest");
	}

	@Override
	public List<FoodDTO> selectList_calory(int calory) {
		return session.selectOne("safefood.food.selectOne", calory);
	}

	@Override
	public int foodCount() {
		return session.selectOne("safefood.food.foodCount");
	}
	
}
