package com.callor.jdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/member")
@Controller
public class MemberController {

	protected final MemberService mService;

	public MemberController(MemberService mService) {
		// TODO Auto-generated constructor stub
		this.mService = mService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "MSG", required = false) String msg, Model model) {

		if (msg == null) {
			model.addAttribute("MSG", "NONE");
		} else if (msg.equals("LOGIN")) {
			model.addAttribute("MSG", "권한없음 로그인 수행!!!");
		} else if (msg.equals("LOGIN_FAIL")) {
			model.addAttribute("MSG", "아이디 비번 확인 !!!");
		}
		return "member/login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("m_username") String username, @RequestParam("m_password") String password,
			HttpSession hSession, Model model) {
		log.debug("사용자 id{} ", username);
		log.debug("password{} ", password);
		
		UserVO userVO = mService.login(username, password);
		
		if(userVO == null) {
			model.addAttribute("MSG","LOGIN_FAIL");
			return "redirect:/member/login";
			}
		hSession.setAttribute("USERVO", userVO);
		return "redirect:/";

	}

     @RequestMapping(value="/logout",method=RequestMethod.GET)
	 public String logout(HttpSession hSession) {
			
			// 로그인된 세션 삭제하기
			hSession.removeAttribute("USERVO");
			hSession = null;
			
			return "redirect:/";
		}

	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}

}
