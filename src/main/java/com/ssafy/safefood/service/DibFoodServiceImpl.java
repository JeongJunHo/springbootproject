package com.ssafy.safefood.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.DibFoodDTO;
import com.ssafy.safefood.repository.DibFoodRepository;


@Service
public class DibFoodServiceImpl implements DibFoodService  {

	@Autowired
	DibFoodRepository repo;
	
	@Override
	public int insert(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return repo.insert(dto);
	}

	@Override
	public List<DibFoodDTO> selectList_id(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectList_id(dto);
	}

	@Override
	public int update(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return repo.update(dto);
	}

	@Override
	public int delete(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return repo.delete(dto);
	}

	@Override
	public DibFoodDTO selectOne(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		return repo.selectOne(dto);
	}

	@Override
	public Map<String, Object> selectTodayDibPlusEatSumList(String id) {
		return repo.selectTodayDibPlusEatSumList(id);
	}

	@Override
	public int addList(DibFoodDTO dto) {
		// TODO Auto-generated method stub
		DibFoodDTO selectOne = selectOne(dto);
		int res=0;
		if(selectOne==null) {
			res = insert(dto);
		}
		else {
			res = update(new DibFoodDTO(dto.getId(),dto.getCode(),selectOne.getCnt()+dto.getCnt()));
		}
		return res;
	}

}

