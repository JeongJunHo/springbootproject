package com.ssafy.safefood.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.AllergyDTO;
import com.ssafy.safefood.dto.MemberDTO;
import com.ssafy.safefood.service.AllergyService;
import com.ssafy.safefood.service.MemberService;





//@WebServlet("/main.do")
//@WebInitParam(name = "aa", value = "Hello")

@Controller
@RequestMapping("/member")
public class MemberController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	MemberService memberService;
	@Autowired
	AllergyService AllergyService;

	
	@RequestMapping("/findidpage")
	public String findPage() {
		return "findid";
	}
	@RequestMapping("/deleteinfo")
	public String deleteinfoPage() {
		return "deleteinfo";
	}

	@RequestMapping("/signup")
	public ModelAndView signupPage(ModelAndView mv) {
		List<AllergyDTO> allergyList = AllergyService.selectList();
		mv.addObject("allergyList",allergyList);
		mv.setViewName("SignUp");
		return mv;
	}

	@RequestMapping("/registermem")
	public ModelAndView memRegPage(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		String pw = req.getParameter("ppw");
		String name = req.getParameter("pname");
		String addr = req.getParameter("paddr");
		String tel = req.getParameter("ptel");
		String[] allergy = req.getParameterValues("pallergy");
		String alStr = new String();
		if (allergy != null) {
			for (int i = 0; i < allergy.length - 1; i++) {
				alStr += allergy[i] + ",";
			}
			alStr += allergy[allergy.length - 1];
		}
		try {
			int insert = memberService.insert(id,pw,name,addr,tel,alStr);
			mv.setViewName("redirect:/food/index");
		}catch(RuntimeException e){
			List<AllergyDTO> allergyList = AllergyService.selectList();
			mv.addObject("allergyList",allergyList);
			mv.addObject("message",e.getMessage());
			mv.setViewName("SignUp");	//에러페이지설정
		}
		return mv;
	}
	
	@RequestMapping("/listmem")
	public ModelAndView memList(HttpServletRequest req, ModelAndView mv) {
		List<MemberDTO> list = memberService.selectList(); // 리스트 불러오기..
		mv.addObject("list",list);
		mv.setViewName("updatepersonalinfo");
		return mv;
	}
	
	@RequestMapping("/deletemem")
	public ModelAndView memDelete(@RequestParam("pid")String pid, ModelAndView mv) {
		memberService.delete(pid,"pw");
		mv.setViewName("redirect:/food/index");
		return mv; 
	}
	
	//여기다시해야함
	@RequestMapping("/updatemem")
	public ModelAndView memUpdate(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		String pw = req.getParameter("ppw");
		String name = req.getParameter("pname");
		String addr = req.getParameter("paddr");
		String tel = req.getParameter("ptel");
		String[] allergy = req.getParameterValues("pallergy");
		String alStr = new String();
		if (allergy != null) {
			for (int i = 0; i < allergy.length - 1; i++) {
				alStr += allergy[i] + ",";
			}
			alStr += allergy[allergy.length - 1];
		}
		memberService.update(id,pw,name,addr,tel,alStr);
		mv.addObject("pid",id);
		mv.setViewName("redirect:/member/infomem");
		return mv;
	}
	

	@RequestMapping("/infomem")
	public ModelAndView memView(@RequestParam("pid")String pid, ModelAndView mv) {
		// 엄무처리
		MemberDTO mem = memberService.selectOne(pid);
		mv.addObject("mem",mem);
		List<AllergyDTO> allergyList = AllergyService.selectList();
		mv.addObject("allergyList",allergyList);
		mv.setViewName("updatepersonalinfo");
		return mv;
	}
	
	@RequestMapping("/allergymaterialrank")
	public ModelAndView allergyMaterialRank(ModelAndView mv) throws ServletException, IOException {
		List<MemberDTO> list = memberService.selectList();
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
		mv.addObject("map", map);
		mv.setViewName("allergy_material");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView memLogin(@RequestParam("pid")String id,@RequestParam("ppw")String pw, ModelAndView mv,HttpServletRequest req) {
		List<MemberDTO> list = memberService.selectList();
		boolean flag=false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			req.getSession().setAttribute("loginid", id);
			mv.setViewName("redirect:/food/index");
		}
		else {
			List<AllergyDTO> allergyList = AllergyService.selectList();
			mv.addObject("allergyList",allergyList);
			mv.setViewName("SignUp");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView memLogout( ModelAndView mv,HttpServletRequest req) {
		
		req.getSession().invalidate();
		mv.setViewName("redirect:/food/index");
		return mv;
	}
	
	@RequestMapping("/findid/{name}/{tel}")
	@ResponseBody
	public String findId(@PathVariable("name")String name,@PathVariable("tel")String tel, ModelAndView mv,HttpServletRequest req) throws IOException {
		System.out.println(name+" "+tel);
		List<MemberDTO> list = memberService.selectList();
		MemberDTO dto=null;
		String text = "";
		boolean flag= false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name) && list.get(i).getTel().equals(tel)) {
				flag=  true;
				dto = list.get(i);
				break;
			}
		}
		String res="";
		if(flag) {
			String new_pw = ""+makeNum();
			memberService.update(dto.getId(), new_pw, dto.getName(), dto.getAddr(), dto.getTel(), dto.getAllergy());
			String t = "임시비밀번호로 로그인 후 비밀번호를 변경해 주세요.";
			res+=(t+" \n"+dto.getId() + " \n" +new_pw);
		}
		else {
			text = "아이디를 찾을 수 없습니다.";
			res+=(text);
		}
		return res;
	}
	
	public String makeNum() {
		int rand = (int) (Math.random()*100000);
		return ""+rand;
	}

}
