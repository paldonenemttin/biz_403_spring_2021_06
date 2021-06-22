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
		// HttpSession에서 USERVO 정보 찾기
		Object obj = hSession.getAttribute("USERVO");
		UserVO userVO = (UserVO) obj;

		// USERVO 정보가 없으면
//		if (userVO == null) {
//			// Login 화면으로 jump
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
		 * form에서 건너온 데이터들을 bookVO에 담은 동안에 book/VO의 변수들(속성, property) 중에
		 * 숫자형 변수가 있을 경우
		 *  건너온 데이터는 무조건 문자열형 이므로 숫자형으로 형 변환ㅇ르 시도한다
		 *  그런데 입력박스에 값이 없는 경우는
		 *  다음고 같은 코드가 내부적으로 실행되면
		 *  bookVO.setBK_pages( Integer.valueOf(""));
		 *  NumberformatExeption이 발생하고 즉시 client에서 
		 */
		Integer ret = bkService.insert(bookVO);
		return "redirect:/books";
	}
}
