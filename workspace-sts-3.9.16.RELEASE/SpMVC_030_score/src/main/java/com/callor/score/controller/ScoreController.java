package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/score")
public class ScoreController {
	
	protected final ScoreDao scDao;
	protected final ScoreService scService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String score(HttpSession httpsession , Model model){
		List<ScoreVO> scList = scService.selectAll();
		log.debug("성적리스트 {}", scList);
		model.addAttribute("SCORES", scList);
		model.addAttribute("BODY","SCORE_VIEW");
		return "home";
	}

}
