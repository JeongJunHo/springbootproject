package com.ssafy.safefood.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ssafy.safefood.dto.FoodDTO;

public interface FoodService {
	/**
	 * 식품 영양 정보 및 식품 정보를 xml 파일에서 로딩하는 기능 
	 */
	public void loadData();
	public int foodCount();
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<FoodDTO> searchAll(String searchType, String searchText);
	
	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 * 아이디로 해당 식품에 알러지 위험군이 있을 경우 allergyWarning true 
	 * @param code	검색할 식품 코드
	 * @param id	로그인아이디
	 * @return	식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public FoodDTO search(int code, String id);
	public FoodDTO selectOne(int code);
	
	/**
	 * 가장 많이 검색한 Food  정보 리턴하기 
	 * @return
	 */
	public List<FoodDTO> searchBest();
	/**
	 * 가장 많이 검색한 상위 6개 Food  정보 리턴하기 
	 * @return
	 */
	public List<FoodDTO> searchBestIndex();
	
	/**
	 * 섭취를 원하는 칼로리량에 따라 칼로리량과 95퍼센트 이상 일치하는 음식의 조합을 보여준다. (알러지 유발 제품 제외)
	 * @param maxCalory
	 * @param id
	 * @return
	 */
	public List<List<FoodDTO>> combinationSearch(int maxCalory, String id);
	public HashMap<String,Integer> materialAccumulator();
	public HashMap<String,List<FoodDTO>> allergyFood(String id);
	public void searchCnt(String sname);
	
}
