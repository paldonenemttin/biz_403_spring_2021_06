package com.team.statea.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String insert(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd/hh:MM:ss");
		
		String datetime = sd.format(date);
		
		BoardVO boardVO = BoardVO.builder().bd_time(datetime).build();
		
		model.addAttribute("FREE", boardVO);
		
		return "board/input";
		
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insert( BoardVO boardVO, MultipartHttpServletRequest m_file) {
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		return "board/view";
		
	}
}
