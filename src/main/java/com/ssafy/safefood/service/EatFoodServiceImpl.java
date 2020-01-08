package com.ssafy.safefood.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.EatFoodDTO;
import com.ssafy.safefood.dto.EatFoodInfoDTO;
import com.ssafy.safefood.repository.EatFoodRepository;

@Service
public class EatFoodServiceImpl implements EatFoodService {
	@Autowired EatFoodRepository eatFoodRepository;

	@Override
	public int insert(EatFoodDTO eatFoodDTO) {
		return eatFoodRepository.insert(eatFoodDTO);
	}

	@Override
	public int update(EatFoodDTO eatFoodDTO) {
		return eatFoodRepository.update(eatFoodDTO);
	}

	@Override
	public int delete(int num) {
		return eatFoodRepository.delete(num);
	}

	@Override
	public EatFoodDTO selectOne(int num) {
		return eatFoodRepository.selectOne(num);
	}

	@Override
	public List<EatFoodInfoDTO> selectList() {
		return eatFoodRepository.selectList();
	}

	@Override
	public List<EatFoodInfoDTO> selectListById(String id) {
		return eatFoodRepository.selectListById(id);
	}

	@Override
	public Map<String, Object> selectSumListById(String id, String sdate, String edate) {
		return eatFoodRepository.selectSumListById(id, sdate, edate);
	}

	@Override
	public List<Map<String, Object>> selectDaySumListById(String id, String sdate, String edate) {
		return eatFoodRepository.selectDaySumListById(id, sdate, edate);
	}

	@Override
	public Map<String, Object> selectTodaySumList(String id) {
		return eatFoodRepository.selectTodaySumList(id);
	}
}
