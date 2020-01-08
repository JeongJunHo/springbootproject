package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.FoodDTO;

public interface FoodRepository {
	public int insert(FoodDTO foodDTO);
	public int updateHit(int code, int hit);
	public FoodDTO selectOne(int code);
	public List<FoodDTO> selectList(String searchType, String searchText);
	public List<FoodDTO> searchBestIndex();
	public List<FoodDTO> searchBest();
	public List<FoodDTO> selectList_calory(int calory);
	public int foodCount();
}
