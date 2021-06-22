package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/books")
public class BooksController {
	
	protected final BookService bkService;
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String books(HttpSession hSession, Model model) {
		// HttpSession���� USERVO ���� ã��
		Object obj = hSession.getAttribute("USERVO");
		UserVO userVO = (UserVO) obj;

		// USERVO ������ ������
//		if (userVO == null) {
//			// Login ȭ������ jump
//			model.addAttribute("MSG", "LOGIN");
//			return "redirect:/member/login";
//		}
		List<BookVO> bookList = bkService.selectAll();
		model.addAttribute("BOOKS", bookList);
		log.debug("Books Root");
		return "books/list";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {

		return "books/input";

	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute BookVO bookVO) {
		
		/*
		 * form���� �ǳʿ� �����͵��� bookVO�� ���� ���ȿ� book/VO�� ������(�Ӽ�, property) �߿�
		 * ������ ������ ���� ���
		 *  �ǳʿ� �����ʹ� ������ ���ڿ��� �̹Ƿ� ���������� �� ��ȯ���� �õ��Ѵ�
		 *  �׷��� �Է¹ڽ��� ���� ���� ����
		 *  ������ ���� �ڵ尡 ���������� ����Ǹ�
		 *  bookVO.setBK_pages( Integer.valueOf(""));
		 *  NumberformatExeption�� �߻��ϰ� ��� client���� 
		 */
		Integer ret = bkService.insert(bookVO);
		return "redirect:/books";
	}
}
