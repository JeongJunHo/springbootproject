package com.ssafy.safefood.service;

import java.util.List;
import java.util.Map;

import com.ssafy.safefood.dto.DibFoodDTO;


public interface DibFoodService {
	public int insert(DibFoodDTO dto);
	public int update(DibFoodDTO dto);
	public int delete(DibFoodDTO dto);
	public int addList(DibFoodDTO dto);
	public DibFoodDTO selectOne(DibFoodDTO dto);
	public List<DibFoodDTO> selectList_id(DibFoodDTO dto);
	public Map<String,Object> selectTodayDibPlusEatSumList(String id);
}
