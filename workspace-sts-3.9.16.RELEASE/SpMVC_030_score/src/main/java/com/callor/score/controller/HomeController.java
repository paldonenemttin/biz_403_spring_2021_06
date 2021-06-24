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
	 * ���� �ٸ� ������ ������ Ŭ���̾�Ʈ ���� ������ 
	 * Request�ϰ� �� ����� �����ͷ� Response�ϴ� ����
	 * 
	 * ���δٸ� ������Ʈ�� ������ Ŭ���̾�Ʈ�� �����Ѵ�
	 * API Service�� �ְ� ���� �����͸� XML type, JSON type���� �����
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<StudentVO> stList = stService.selectAll();
	
		log.debug("Controller {} ", stList.toString());
		
		return "redirect:/score/list";
	}
	
	
}
