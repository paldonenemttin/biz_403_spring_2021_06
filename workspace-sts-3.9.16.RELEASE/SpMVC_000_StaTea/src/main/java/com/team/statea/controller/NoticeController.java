package com.team.statea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.model.NoticeVO;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@RequestMapping(value="/list" , method = RequestMethod.GET)
	public String list() {
		return "notice/list";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.GET)
	public String input() {
		return "notice/input";
	}

	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String input(NoticeVO ntVO, MultipartHttpServletRequest m_file) {
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/notice/view/{seq}", method = RequestMethod.GET)
	public String view(@PathVariable("seq") String seq, Model model) {
		
		return "notice/view";
	}
}
