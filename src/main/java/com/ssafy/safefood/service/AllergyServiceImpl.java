package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.AllergyDTO;
import com.ssafy.safefood.repository.AllergyRepository;

@Service
public class AllergyServiceImpl implements AllergyService {

	static String[] AllergyFirstList = {"대두","땅콩","우유","게"
										,"새우","참치","연어","쑥"
										,"소고기","닭고기","돼지고기"
										,"복숭아","민들레","계란흰자"};
	
	@Autowired
	AllergyRepository repo;
	
	
	@Override
	public void loadData() {
		for(int i=0;i<AllergyFirstList.length;i++) {
			AllergyDTO dto = new AllergyDTO(i+1,AllergyFirstList[i]);
			AllergyDTO selectOneName = repo.selectOneName(dto);
			if(selectOneName==null) {
				repo.insert(dto);
			}
		}
	}
	@Override
	public int insert(AllergyDTO m) {
		// TODO Auto-generated method stub
		return repo.insert(m);
	}

	@Override
	public int delete(AllergyDTO m) {
		// TODO Auto-generated method stub
		return repo.delete(m);
	}

	@Override
	public int update(AllergyDTO m) {
		// TODO Auto-generated method stub
		return repo.update(m);
	}

	@Override
	public List<AllergyDTO> selectList() {
		// TODO Auto-generated method stub
		return repo.selectList();
	}

	@Override
	public AllergyDTO selectOne(AllergyDTO m) {
		// TODO Auto-generated method stub
		return repo.selectOne(m);
	}

}
