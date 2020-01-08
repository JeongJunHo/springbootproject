package com.ssafy.safefood.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.EatFoodDTO;
import com.ssafy.safefood.dto.EatFoodInfoDTO;

@Repository
public class EatFoodRepositoryImpl implements EatFoodRepository {
	@Autowired
	SqlSession session;
	
	static final String NAMESPACE = "safefood.eatFood.";

	@Override
	public int insert(EatFoodDTO eatFoodDTO) {
		return session.insert(NAMESPACE + "insert", eatFoodDTO);
	}

	@Override
	public int update(EatFoodDTO eatFoodDTO) {
		return session.update(NAMESPACE + "update", eatFoodDTO);
	}

	@Override
	public int delete(int num) {
		return session.delete(NAMESPACE + "delete", num);
	}

	@Override
	public EatFoodDTO selectOne(int num) {
		return session.selectOne(NAMESPACE + "selectOne", num);
	}

	@Override
	public List<EatFoodInfoDTO> selectList() {
		return session.selectList(NAMESPACE + "selectList");
	}

	@Override
	public List<EatFoodInfoDTO> selectListById(String id) {
		return session.selectList(NAMESPACE + "selectListById", id);
	}

	@Override
	public Map<String, Object> selectSumListById(String id, String sdate, String edate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("sdate", sdate);
		map.put("edate", edate);
		return session.selectOne(NAMESPACE + "selectSumListById", map);
	}

	@Override
	public List<Map<String, Object>> selectDaySumListById(String id, String sdate, String edate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("sdate", sdate);
		map.put("edate", edate);
		return session.selectList(NAMESPACE + "selectDaySumListById", map);
	}

	@Override
	public Map<String, Object> selectTodaySumList(String id) {
		return session.selectOne(NAMESPACE + "selectTodaySumList", id);
	}
}
