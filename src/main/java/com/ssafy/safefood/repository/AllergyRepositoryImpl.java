package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.AllergyDTO;

@Repository
public class AllergyRepositoryImpl implements AllergyRepository{

	@Autowired
	SqlSession session;

	
	@Override
	public int insert(AllergyDTO m) {
		// TODO Auto-generated method stub
		return session.insert("safefood.allergy.insert",m);

	}

	@Override
	public int delete(AllergyDTO m) {
		// TODO Auto-generated method stub
		return session.delete("safefood.allergy.delete",m);
	}

	@Override
	public int update(AllergyDTO m) {
		// TODO Auto-generated method stub
		return session.update("safefood.allergy.update",m);
	}

	@Override
	public List<AllergyDTO> selectList() {
		// TODO Auto-generated method stub
		return session.selectList("safefood.allergy.selectList");
	}

	@Override
	public AllergyDTO selectOne(AllergyDTO m) {
		// TODO Auto-generated method stub
		return session.selectOne("safefood.allergy.selectOne",m);
	}

	@Override
	public AllergyDTO selectOneName(AllergyDTO m) {
		// TODO Auto-generated method stub
		return session.selectOne("safefood.allergy.selectOne",m);
	}

}
