package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.AllergyDTO;

public interface AllergyService {
	public int insert(AllergyDTO m);
	public int delete(AllergyDTO m);
	public int update(AllergyDTO m);
	public List<AllergyDTO> selectList();
	public AllergyDTO selectOne(AllergyDTO m);
	public void loadData();
}
