package com.callor.score.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.dao.ext.StudentDao;
import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value="student")
public class StudentController {

	protected final StudentService stService;
	protected final StudentDao stDao;
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String list(HttpSession httpSession,Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		log.debug("Controller {} ", stList.toString());
		model.addAttribute("STUDS", stList);
		model.addAttribute("BODY","STUDENT_VIEW");
		return "home";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "home";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String input(StudentVO studentVO , Model model) {
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "redirect:/home";
	}
}
