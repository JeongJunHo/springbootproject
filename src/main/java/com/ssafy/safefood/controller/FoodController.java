package com.ssafy.safefood.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.AllergyDTO;
import com.ssafy.safefood.dto.FoodDTO;
import com.ssafy.safefood.service.AllergyService;
import com.ssafy.safefood.service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
	@ExceptionHandler(Exception.class)
	public String allException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "allErrorPage";
	}
	
	@Autowired FoodService foodService;
	@Autowired AllergyService allergyService;
	
	@GetMapping("/index")
	public ModelAndView index(ModelAndView mv) {
		List<FoodDTO> list = foodService.searchBestIndex();
		mv.addObject("list", list);
		mv.setViewName("index");
		
		return mv;
	}
	
	@GetMapping("/bestintakeinfo")
	public ModelAndView bestIntakeInfo(ModelAndView mv) {
		List<FoodDTO> list = foodService.searchBest();
		mv.addObject("list", list);
		mv.setViewName("bestintakeinfo");
		
		return mv;
	}
	
	@GetMapping("/productinfo")
	public ModelAndView productinfo(String searchType, String searchText, ModelAndView mv) {
		System.out.println(searchType + " " + searchText);
		List<FoodDTO> list = foodService.searchAll(searchType, searchText);
		//rankService.searchCnt(searchText);
		//ArrayList<RankDTO> rList = rankServie.searchRank();
		//mv.addObject("rlist", rList);
		mv.addObject("list", list);
		mv.setViewName("productinfo");
		
		return mv;
	}
	
	@GetMapping("/productdetail")
	public ModelAndView productDetail(Integer code, HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		FoodDTO foodDTO = foodService.search(code, id);
		String material = foodDTO.getMaterial();
		List<AllergyDTO> selectList = allergyService.selectList();
		String containList = "";
		for(int i=0;i<selectList.size();i++) {
			if(material.contains(selectList.get(i).getName())) {
				containList+=selectList.get(i).getName()+" ";
			}
		}
		
		mv.addObject("food", foodDTO);
		mv.addObject("containList", containList);
		mv.setViewName("productdetail");
		
		return mv;
	}
	
	@GetMapping("/fitcombsearch")
	public ModelAndView fitCombSearch(String searchCalory, HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		Integer maxCalory = 0;
		if (searchCalory != null && searchCalory != "") {
			maxCalory = Integer.parseInt(searchCalory);
		}
		
		List<List<FoodDTO>> combSearchList = foodService.combinationSearch(maxCalory, id);
		
		mv.addObject("list", combSearchList);
		mv.setViewName("fitcombsearch");
		
		return mv;
	}
	
	@GetMapping("/materialusechart")
	public ModelAndView materialUseChart(ModelAndView mv) {
		HashMap<String, Integer> map = foodService.materialAccumulator();
		mv.addObject("map", map);
		mv.setViewName("materialusechart");
		return mv;
	}
	
	@GetMapping("/allergyfood")
	public ModelAndView allergyFood(HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		HashMap<String, List<FoodDTO>> map = foodService.allergyFood(id);
		mv.addObject("map", map);
		mv.setViewName("allergyfood");
		return mv;
	}
}
