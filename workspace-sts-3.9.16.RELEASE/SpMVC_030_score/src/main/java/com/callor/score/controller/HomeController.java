package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	protected final StudentService stService;
	
	/*
	 * 서로 다른 서버와 서버와 클러이언트 간에 조건을 
	 * Request하고 그 결과를 데이터로 Response하는 서비스
	 * 
	 * 서로다른 프로젝트로 서버와 클라이언트를 개발한다
	 * API Service는 주고 받은 데이터를 XML type, JSON type으로 만든다
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<StudentVO> stList = stService.selectAll();
	
		log.debug("Controller {} ", stList.toString());
		
		return "redirect:/score/list";
	}
	
	
}
