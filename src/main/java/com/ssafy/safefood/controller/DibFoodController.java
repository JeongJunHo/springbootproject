package com.ssafy.safefood.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.DibFoodDTO;
import com.ssafy.safefood.service.DibFoodService;
import com.ssafy.safefood.service.EatFoodService;






//@WebServlet("/main.do")
//@WebInitParam(name = "aa", value = "Hello")

@Controller
@RequestMapping("/dibfood")
public class DibFoodController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DibFoodService ser;
	@Autowired
	EatFoodService eatFoodService;

	@RequestMapping("/searchall")
	public ModelAndView selectAll(HttpServletRequest req, ModelAndView mv) {
		DibFoodDTO dto = new DibFoodDTO();
		dto.setId((String)req.getSession().getAttribute("loginid"));
		List<DibFoodDTO> list = ser.selectList_id(dto); // 리스트 불러오기..
		mv.addObject("list",list);
		mv.setViewName("didfoodinfo");
		return mv;
	}

	@RequestMapping("/dibchartpage")
	public ModelAndView chartpage(HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		mv.addObject("todayEatMap", eatFoodService.selectTodaySumList(id));
		mv.addObject("eatPlusDibMap", ser.selectTodayDibPlusEatSumList(id));
		mv.setViewName("dibchartpage");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		
		DibFoodDTO dto = new DibFoodDTO();
		dto.setId((String)req.getSession().getAttribute("loginid"));
		List<DibFoodDTO> list = ser.selectList_id(dto); // 리스트 불러오기..
	//	System.out.println(((DibFoodNameImgListDTO)list.get(0)).get);
		mv.addObject("list",list);
		mv.setViewName("didfoodinfo");
		return mv;
	}
	
	@RequestMapping("/takefood")
	@ResponseBody
	public String dibfoodinsert(HttpServletRequest req, ModelAndView mv) throws UnsupportedEncodingException {
		String id = (String) req.getParameter("loginid");
		int code = Integer.parseInt(req.getParameter("code"));
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		

		System.out.println("takefood id= "+id);
		System.out.println("takefood code= "+code);
		
		String str="";
		DibFoodDTO dto = new DibFoodDTO();
		dto.setId(id);
		dto.setCode(code);
		DibFoodDTO selectOne = ser.selectOne(dto);
		int res=0;
		if(selectOne==null) {
			res = ser.insert(new DibFoodDTO(id,code,cnt));
		}
		else {
			res = ser.update(new DibFoodDTO(id,code,selectOne.getCnt()+cnt));
		}
		if(res>0) {
			str="찜목록에 추가되었습니다.";
		}
		else {
			str = "실패했습니다?";
		}
		return str;
	}



}
