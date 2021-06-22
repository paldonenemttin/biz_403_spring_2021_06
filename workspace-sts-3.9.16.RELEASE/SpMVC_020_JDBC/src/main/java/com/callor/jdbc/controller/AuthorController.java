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
	 * cp_title�� Req�� ���� �޾� ���� ������ �ϴµ�
	 * Req�� �Ҷ� cp_title ������ ������ ������
	 * 400 http Status ������ �߻��Ѵ�
	 * 400 ������ ���� App����� �������� ����� �����ϱ� ����� ������ �ȴ�
	 * 
	 * �ܼ��� ���� (VO, DTO MAP ������ �ƴ� ���� ����)�� ����
	 * @Requestparam�� required�ɼ��� false�� �����ϰ�
	 * default���� ���Ƿ� �����صθ� �ڵ峻���� �ڵ��� �� �� �մ�
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
