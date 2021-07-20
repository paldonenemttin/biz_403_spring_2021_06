package com.callor.gallery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	protected final MemberService mService;
	
	@RequestMapping(value="join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY", "JOIN");
		return "home";
	}

	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(Model model,MemberVO memberVO) {
		log.debug("ȸ������ ����{}",memberVO.toString());
		memberVO = mService.join(memberVO);
		model.addAttribute("BODY", "JOIN");
		return "home";
	}
	
	// �޴����� �α����� Ŭ��������
	@RequestMapping(value="/login/{url}")
	public String login(@PathVariable("url") String url) {
		return "redirect:/member/login?url=login";
	}
	
	// �ٸ������� redirect ������
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(@RequestParam(name="url",required = false, defaultValue = "NONE") String url ,Model model) {
		model.addAttribute("LOGIN_FAIL","LOGIN_REQ");
		model.addAttribute("BODY", "LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO memberVO,Model model, HttpSession session) {
		
		memberVO = mService.login(memberVO, model);
		if(memberVO == null) {
			model.addAttribute("BODY", "LOGIN");
			return "home";
		}else {
			// ����� id�� ����, ��й�ȣ id�� ����
			// HttpSession�� ����� ������ ��� memberVO�� �Ӽ����� �����Ѵ�
			session.setAttribute("MEMBER", memberVO);
			/*
			 * httpSession�� �Ӽ����� setting�� ���� ��� Ÿ���̶� ��� ����
			 * ������ httpSession�� ��� �Ӽ��� ���Ƿ� �����ϰų� �ʱ�ȭ�ϰų�
			 * ������ ���߰ų� ���� ������ �������� ������
			 * ���� �޸𸮿� ������ �����ִ�
			 * 
			 * 1. ������ ����ũ���� �����͸� ��ƶ�
			 * 2. �ʿ������ �ݵ�� �Ҹ���Ѷ�
			 * 3. �ڵ��Ҹ�Ǵ� ������ �� �����϶�
			 */
			return "redirect:/";		
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/id_check" , method = RequestMethod.GET)
	public String id_check(String m_userid) {
		log.debug("�˻縦 ������ id {}",m_userid);
		MemberVO memberVO = mService.findById(m_userid);
		if(memberVO == null) {
			return "NOT_USE_ID";
		} else {
			return "USE_ID";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("MEMBER");
		return "redirect:/";
	}

}
