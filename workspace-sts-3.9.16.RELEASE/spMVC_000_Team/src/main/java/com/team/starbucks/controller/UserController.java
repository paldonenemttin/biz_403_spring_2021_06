package com.team.starbucks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.starbucks.model.UserVO;
import com.team.starbucks.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Controller
public class UserController {
	@Qualifier("userServiceV1")
	protected final UserService usService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY", "JOIN");
		return "home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO usVO, Model model) {
		if (usVO == null) {
			log.debug("�쉶�썝媛��엯�떎�뙣");
			model.addAttribute("JOINMSG", "FAIL");
			//			model.addAttribute("BODY", "JOIN");
			return null;
		} else {
			usService.join(usVO);
			model.addAttribute("BODY", "LOGIN");
			return "home";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	public String id_check(String user_id) {

		log.debug("以묐났 寃��궗瑜� �닔�뻾�븷 ID: {}", user_id);
		UserVO userVO = usService.findById(user_id);

		if (userVO == null) {
			return "NOT_USE_ID";
		} else {
			return "USE_ID";
		}
	}

	@RequestMapping(value = "/login/{url}")
	public String login(@PathVariable("url") String url) {

		return "redirect:/user/login?url=login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String msg, Model model) {

		model.addAttribute("BODY", "LOGIN");
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO usVO, Model model, HttpSession session) {

		UserVO userVO = usService.login(usVO);

		if (userVO == null) {
			session.setAttribute("LOGIN", null);
			model.addAttribute("FAIL", "FAIL");
			return "/user/login";
		} else {
			session.setAttribute("LOGIN", userVO);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN");
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userUpdate(@RequestParam("user_id") String user_id, HttpSession session, Model model)
			throws Exception {
		UserVO userVO = (UserVO) session.getAttribute("LOGIN");
		String loginId = userVO.getUser_id();
		log.debug("濡쒓렇�씤�븳 �븘�씠�뵒 {}", loginId);
		// String updateId = user_id;
		log.debug("�닔�젙�븷 �븘�씠�뵒 {}", user_id);
		if (user_id.equals(loginId)) {
			model.addAttribute("USERVO", userVO);
			model.addAttribute("BODY", "UPDATE-ID");
			return "home";
		} else {
			model.addAttribute("BODY", "FAIL_LOGIN");
			log.debug("�쉶�썝�젙蹂� �닔�젙吏꾩엯 �떎�뙣 ", userVO.toString());
			return "home";
		}
	}

	@RequestMapping(value = "/updateID", method = RequestMethod.POST)
	public String userUpdate(@RequestParam("user_id") String user_id, UserVO userVO, HttpSession session, Model model)
			throws Exception {
		userVO = (UserVO) session.getAttribute("LOGIN");
		log.debug("�쉶�썝�젙蹂� �닔�젙�젙蹂� {}", userVO.toString());
//		usService.insertOrUpdate(userVO);
		usService.update(userVO);
		
		return "redirect:/custom/mylist";
	}
}