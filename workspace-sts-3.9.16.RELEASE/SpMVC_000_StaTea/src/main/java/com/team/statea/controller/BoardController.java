package com.team.statea.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.statea.model.BoardVO;
import com.team.statea.model.ImageVO;
import com.team.statea.model.LikeVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession httpSession, Model model) {
		model.addAttribute("BOARDS");// 나중에 impl 추가
		return "board/list";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String insert() {
		return "board/input";
		
	}
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insert(LikeVO likeVO, BoardVO boardVO, ImageVO imgVO) {
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		return "board/view";
		
	}
}
