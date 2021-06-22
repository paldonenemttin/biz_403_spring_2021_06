package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/author")
public class AuthorController {

	protected final AuthorService auService;

	public AuthorController(AuthorService auService) {
		// TODO Auto-generated constructor stub
		this.auService = auService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		UserVO userVO = (UserVO) hSession.getAttribute("USERVO");
		if (userVO == null) {
			model.addAttribute("MSG", "LOGIN");
			return "redirect:/member/login";
		}
		return "author/list";
	}
	
	/*
	 * cp_title을 Req로 부터 받아 변수 세팅을 하는데
	 * Req를 할때 cp_title 변수를 보내지 않으면
	 * 400 http Status 오류가 발생한다
	 * 400 오류는 서버 App디버깅 과정에서 상당히 관리하기 어려운 오류가 된다
	 * 
	 * 단순한 변수 (VO, DTO MAP 형식이 아닌 단일 변수)의 경우는
	 * @Requestparam의 required옵션을 false로 선언하고
	 * default값을 임의로 설정해두면 코드내에서 핸들을 할 수 잇다
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam(name = "au_name", required = false, defaultValue = "")
							String au_name, Model model) {
		if(au_name == null || au_name.equals("")) {
		List<AuthorVO> authorList = auService.selectAll();
		model.addAttribute("AUTH_LIST", authorList);
		}
		else if(au_name == null || au_name.equals("")) {
			List<AuthorVO> authorList = auService.findByNameAndTel(au_name);
			model.addAttribute("AUTH_LIST", authorList);
		}
		return "author/search";
		
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "author/input";
	}

}
