package com.ssafy.safefood.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.EatFoodInfoDTO;
import com.ssafy.safefood.service.EatFoodService;
import com.ssafy.safefood.util.DateUtil;

@Controller
@RequestMapping("/eatfood")
public class EatFoodController {
	@Autowired EatFoodService eatFoodService;

	@GetMapping("/eatfoodinfo")
	public ModelAndView eatFoodInfo(HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		
		List<EatFoodInfoDTO> list = eatFoodService.selectListById(id);
		
		mv.addObject("list", list);
		mv.setViewName("eatfoodinfo");
		
		return mv;
	}

	@GetMapping("/eatfoodchart")
	public ModelAndView eatFoodChart(String sdate, String edate, HttpSession session,  ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		
		if(sdate == null) {
			sdate = DateUtil.getNowDateFormatYYYYMMDD();
		}
		if(edate == null) {
			edate = DateUtil.getNowDateFormatYYYYMMDD();
		}
		
		mv.addObject("totalEatMap", eatFoodService.selectSumListById(id, sdate, edate));
		mv.addObject("dayTotalEatMapList", eatFoodService.selectDaySumListById(id, sdate, edate));
		mv.addObject("sdate", sdate);
		mv.addObject("edate", edate);
		mv.setViewName("eatfoodchart");
		
		return mv;
	}
}
