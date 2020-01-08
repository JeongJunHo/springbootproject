package com.ssafy.safefood.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.FoodDTO;
import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.repository.FoodRepository;
import com.ssafy.safefood.repository.MemberRepository;
import com.ssafy.safefood.util.FoodSaxParser;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired FoodRepository foodRepository;
	@Autowired MemberRepository memberRepository;
	@Autowired FoodSaxParser foodSaxParser;

	@Override
	public void loadData() {
		List<FoodDTO> list = foodSaxParser.getFoods();
		for (FoodDTO food : list) {
			if(foodRepository.selectOne(food.getCode()) == null) {
				foodRepository.insert(food);
			}
		}
	}

	@Override
	public int foodCount() {
		return foodRepository.foodCount();
	}

	@Override
	public List<FoodDTO> searchAll(String searchType, String searchText) {
		return foodRepository.selectList(searchType, searchText);
	}

	@Override
	public FoodDTO search(int code, String id) {
		FoodDTO foodDTO = foodRepository.selectOne(code);
		foodDTO.setHit(foodDTO.getHit()+1);
		foodRepository.updateHit(code, foodDTO.getHit());
		
		//로그인 아이디가 있다면
		if(id != null) {
			MemberDTO memberDTO = memberRepository.selectOne(id);
			String[] split = memberDTO.getAllergy().split(",");
			for (String str : split) {
				if(foodDTO.getMaterial().contains(str)) {
					foodDTO.setAllergyWarning(true);
					break;
				}
			}
		}
				
		return foodDTO;
	}
	
	@Override
	public FoodDTO selectOne(int code) {
		FoodDTO foodDTO = foodRepository.selectOne(code);
		return foodDTO;
	}

	@Override
	public List<FoodDTO> searchBest() {
		return foodRepository.searchBest();
	}

	@Override
	public List<FoodDTO> searchBestIndex() {
		return foodRepository.searchBestIndex();
	}

	@Override
	public List<List<FoodDTO>> combinationSearch(int maxCalory, String id) {
		List<List<FoodDTO>> combSearchList = new ArrayList<List<FoodDTO>>();
		
		if(maxCalory > 0) {
			MemberDTO memberVO = memberRepository.selectOne(id);
			List<FoodDTO> foodList = foodRepository.selectList(null, null);
			//사용자의 알러지 제품이 있다면
			if(memberVO.getAllergy() != null) {
				String[] allergys = memberVO.getAllergy().split(",");
				for (Iterator iterator = foodList.iterator(); iterator.hasNext();) {
					FoodDTO foodDTO = (FoodDTO) iterator.next();
					for (String material : allergys) {
						//알러지 제품을 포함하고 있다면 삭제
						if(foodDTO.getMaterial().contains(material)) {
							iterator.remove();
							break;
						}
					}
				}
			}
			
			comb(maxCalory, combSearchList, foodList, new boolean[foodList.size()], 0, 0.0);
		}
		
		return combSearchList;
	}

	@Override
	public HashMap<String, Integer> materialAccumulator() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		List<FoodDTO> foodList = foodRepository.selectList(null, null);
		for (FoodDTO foodDTO : foodList) {
			String material = foodDTO.getMaterial(); 
			material = material.replace("[", ",");
			material = material.replace("]", ",");
			material = material.replace("{", ",");
			material = material.replace("}", ",");
			
			String[] split = material.split(",");
//			boolean bracket=false;
			int bracket=0;
			String input="";
			for (String str : split) {
				if(str.length()>0) {
					bracket+=countBracket(str);
					input+=str;
					if(bracket==0) {	//넣어도 될때
						input = makeNoBracket(input);
						if(map.get(input) != null ) {
							map.put(input, map.get(input) + 1);
						}else {
							map.put(input, 1);
						}
						input="";	//집어넣고 나서 초기화
					}
				}
			}
		}
		
		return map;
	}
	public String makeNoBracket(String str) {
		String s="";
		boolean flag=false;
		int first=0;
		int last=str.length();
		for(int i=0;i<str.length();i++) {
			if(!flag&&str.charAt(i)=='(') {
				flag=true;
				first=i;
			}
			else if(str.charAt(i)==')') {
				last=i;
			}
		}
		if(flag) {
			s=str.substring(0, first)+str.substring(last+1,str.length());
			return s;
		}
		return str;
	}
	public int countBracket(String str){
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				count++;
			}
			else if(str.charAt(i)==')') {
				count--;
			}
		}
		return count;
	}
	@Override
	public HashMap<String, List<FoodDTO>> allergyFood(String id) {
		HashMap<String,List<FoodDTO>> map = new HashMap<String,List<FoodDTO>>();
		
		MemberDTO memberDTO = memberRepository.selectOne(id);
		List<FoodDTO> foodList = foodRepository.selectList(null, null);
		//사용자의 알러지 제품이 있다면
		if(memberDTO.getAllergy() != null) {
			String[] allergys = memberDTO.getAllergy().split(",");
			
			for (String material : allergys) {
				if(map.get(material) == null) {
					map.put(material, new ArrayList<FoodDTO>());
				}
				
				List<FoodDTO> tmpList = map.get(material);
				
				for (FoodDTO foodDTO : foodList) {
					if(foodDTO.getMaterial().contains(material) || foodDTO.getName().contains(material)) {
						tmpList.add(foodDTO);
					}
				}
				
				map.put(material, tmpList);
			}
		}
		
		return map;
	}

	@Override
	public void searchCnt(String sname) {
		//rank service로 옮길 것
//		rankDAOImpl.searchCnt(sname);
	}
	
	private void comb(int maxCalory, List<List<FoodDTO>> combSearchList, List<FoodDTO> foodList, boolean[] visited, int idx, double sum) {
		if(sum > maxCalory) {
			return;
		}
		
		if(idx == foodList.size()) {
			if(sum >= maxCalory*0.95) {
				List<FoodDTO> tmp = new ArrayList<FoodDTO>();
				for (int i = 0; i < visited.length; i++) {
					if(visited[i]) {
						tmp.add(foodList.get(i));
					}
				}
				
				combSearchList.add(tmp);
			}
			return;
		}
		
		visited[idx] = true;
		comb(maxCalory, combSearchList, foodList, visited, idx+1, sum + foodList.get(idx).getCalory());
		visited[idx] = false;
		comb(maxCalory, combSearchList, foodList, visited, idx+1, sum);
	}
}
