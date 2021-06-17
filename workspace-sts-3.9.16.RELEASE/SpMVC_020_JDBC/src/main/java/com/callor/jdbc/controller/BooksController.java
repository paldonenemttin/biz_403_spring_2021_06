package com.callor.jdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/books")
public class BooksController {

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String books(HttpSession hSession, Model model) {
		// HttpSession���� USERVO ���� ã��
		Object obj = hSession.getAttribute("USERVO");
		UserVO userVO = (UserVO) obj;

		// USERVO ������ ������
		if (userVO == null) {
			// Login ȭ������ jump
			model.addAttribute("MSG", "LOGIN");
			return "redirect:/member/login";
		}

		log.debug("Books Root");
		return "books/list";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {

		return "books/input";

	}
}
