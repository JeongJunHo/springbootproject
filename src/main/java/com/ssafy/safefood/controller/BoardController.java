package com.ssafy.safefood.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.dto.BoardDTO;
import com.ssafy.safefood.service.BoardService;
import com.ssafy.safefood.util.DateUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	@ExceptionHandler(Exception.class)
	public String allException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "allErrorPage";
	}
	
	@Autowired
	BoardService boardService;

	@GetMapping("/noticeinsert")
	public String noticeInsert() {
		return "notice_insert";
	}
	
	@PostMapping("/insertboard")
	public ModelAndView insertBoard(BoardDTO boardDTO, HttpSession session, ModelAndView mv) {
		String id = (String) session.getAttribute("loginid");
		boardDTO.setId(id);
		
		int res = boardService.insert(boardDTO);
		mv.setViewName("redirect:/board/listboard");
		
		return mv;
	}
	
	@GetMapping("/listboard")
	public ModelAndView listBoard(ModelAndView mv) {
		String nowDateFormatYYYYMMDD = DateUtil.getNowDateFormatYYYYMMDD();
		
		List<BoardDTO> list = boardService.selectList();
		mv.addObject("blist", list);
		mv.setViewName("notice_list");
		
		return mv;
	}
	
	@GetMapping("/noticeupdate")
	public ModelAndView noticeUpdate(BoardDTO boardDTO, ModelAndView mv) {
		boardDTO = boardService.selectOne(boardDTO);
		mv.addObject("board", boardDTO);
		mv.setViewName("notice_update");
		
		return mv;
	}
	
	@PostMapping("/updateboard")
	public ModelAndView updateBoard(BoardDTO boardDTO, ModelAndView mv) {
		boardService.update(boardDTO);
		mv.setViewName("redirect:/board/listboard");
		
		return mv;
	}
	
	@GetMapping("/deleteboard")
	public ModelAndView deleteBoard(BoardDTO boardDTO, ModelAndView mv) {
		boardService.delete(boardDTO);
		mv.setViewName("redirect:/board/listboard");
		
		return mv;
	}
	
	@GetMapping("/infoboard")
	public ModelAndView infoBoard(BoardDTO boardDTO, ModelAndView mv) {
		boardDTO = boardService.selectOne(boardDTO);
		boardDTO.setHit(boardDTO.getHit()+1);
		boardService.update(boardDTO);
		mv.addObject("board", boardDTO);
		mv.setViewName("notice_view");
		
		return mv;
	}
}
