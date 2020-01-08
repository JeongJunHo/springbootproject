package com.ssafy.safefood.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.repository.MemberRepository;



@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("MemberRepositoryImpl")
	MemberRepository repo;

	@Override
	public int insert(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		System.out.println("service");
		return repo.insert(new MemberDTO(id, pw, name, addr, tel, allergy));
	}

	@Override
	public int update(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		return repo.update(new MemberDTO(id, pw, name, addr, tel, allergy));
		
	}


	@Override
	public MemberDTO selectOne(String num) {
		// TODO Auto-generated method stub
		return repo.selectOne(num);
	}

	@Override
	public List<MemberDTO> selectList() {
		// TODO Auto-generated method stub
		return repo.selectList();
	}

	@Override
	public HashMap<String, Integer> allUserAllergy() {
		List<MemberDTO> list = this.selectList();
		String[] str = new String[list.size()];
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < list.size(); i++) {
			String allergy = list.get(i).getAllergy();
			str = allergy.split(",");
			for (int j = 0; j < str.length; j++) {
				if (map.get(str[j]) == null) {
					map.put(str[j], 1);
				} else {
					map.put(str[j], map.get(str[j]) + 1);
				}
			}
		}
		
		return map;
	}

	@Override
	public int delete(String id, String pw) {
		// TODO Auto-generated method stub
		if(selectOne(id).getPw().equals(pw)) {
			return repo.delete(id);
		}
		else
			return -1;
	}

	@Override
	public String find_pw(String id, String addr) {
		// TODO Auto-generated method stub
		String res="";
		MemberDTO dto = selectOne(id);
		String newPw=makePw();
		if(dto!=null) {
			if(dto.getAddr().equals(addr)) {
				update(id, newPw, dto.getName(), dto.getAddr(), dto.getTel(), dto.getAllergy());
				res+="새로운 비밀번호를 발급해드렸습니다.\n다시 로그인 후 비밀번호를 변경해 주세요\nid : "+id+"\npw : "+newPw;
			}else {
				res+="이메일이 틀렸습니다.";
			}
		}else {
			res+="아이디를 찾을 수 없습니다.";
		}
		return res;
	}
	public String makePw() {
		int ran = (int) (Math.random()*1000000);
		String newpw=""+ran;
		return newpw;
	}

	@Override
	public String find_id(String name, String addr) {
		// TODO Auto-generated method stub
		String res="";
		MemberDTO f_dto = new MemberDTO();
		f_dto.setName(name);
		f_dto.setAddr(addr);
		MemberDTO dto = repo.selectOne_name_addr(f_dto);
		if(dto==null) {
			res+="아이디가 존재하지 않습니다.";
		}else {
			res="아이디를 찾았습니다.\n"+dto.getId();
		}
		return res;
	}
	
}
