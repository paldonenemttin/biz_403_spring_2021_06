package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.dao.ext.StudentDao;
import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value = "student")
public class StudentController {

	protected final StudentService stService;
//	protected final ScoreService scService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession httpSession, Model model) {

		List<StudentVO> stList = stService.selectAll();
		log.debug("Controller {} ", stList.toString());
		model.addAttribute("STUDS", stList);
		model.addAttribute("BODY", "STUDENT_VIEW");
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String insert(Model model) {
		StudentVO stVO = new StudentVO();
		stVO.setSt_num(stService.makeStNum());
		model.addAttribute("ST", stVO);
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(StudentVO studentVO, Model model) {
		log.debug("Req 학생정보: {}", studentVO.toString());
		int ret = stService.insert(studentVO);
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "redirect:/student/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String st_num, Model model) {

//		 List<SubjectAndScoreDTO> ssList = scService.selectScore(st_num);
		String ret = stService.detail(model, st_num);
//		 model.addAttribute("SSLIST", ssList);
		model.addAttribute("BODY", "STUDENT_DETAIL");
		return "home";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
//	public String detail(@RequestParam(name="subject") List<String> subject, @RequestParam(name="score") List<String> score){
	public String detail(ScoreInputVO scInputVO, Model model) {
//		log.debug("sibject : {} ", subject.toString());
//		log.debug("score : {}", score.toString());
		
		log.debug("scoreInput : {}",scInputVO.toString());
		String ret = stService.scoreInput(scInputVO);
		String st_num = scInputVO.getSt_num();
		/*
		 * redirect를 수행할때 query string을 보내고 싶으면
		 * 해당 변수와 값을 model에 속성(Attribute)로 추가(add)
		 * 
		 * redirect:/student/detail?st_num
		 * 
		 */
		model.addAttribute("st_num", st_num);
		return "redirect:/student/detail";
	}
}
