package com.ssafy.safefood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.service.AllergyService;
import com.ssafy.safefood.service.FoodService;

@Controller
public class MainController {
	@Autowired FoodService foodService;
	@Autowired AllergyService allergyService;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		foodService.loadData();
		allergyService.loadData();
		
//		return "redirect:/food/index";
		mv.setViewName("redirect:/food/index");
		return mv;
	}
}
