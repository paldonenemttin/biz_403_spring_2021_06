package com.team.statea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.statea.model.ImageVO;
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
	public String input(NoticeVO ntVO, ImageVO imgVO) {
		return "notice/input";
	}
}
