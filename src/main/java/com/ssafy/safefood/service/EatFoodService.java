package com.ssafy.safefood.service;

import java.util.List;
import java.util.Map;

import com.ssafy.safefood.dto.EatFoodDTO;
import com.ssafy.safefood.dto.EatFoodInfoDTO;

public interface EatFoodService {
	public int insert(EatFoodDTO eatFoodDTO);
	public int update(EatFoodDTO eatFoodDTO);
	public int delete(int num);
	public EatFoodDTO selectOne(int num);
	public List<EatFoodInfoDTO> selectList();
	public List<EatFoodInfoDTO> selectListById(String id);
	public Map<String, Object> selectSumListById(String id, String sdate, String edate);
	public List<Map<String, Object>> selectDaySumListById(String id, String sdate, String edate);
	public Map<String, Object> selectTodaySumList(String id);
}
