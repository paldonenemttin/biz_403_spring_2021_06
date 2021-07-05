package com.callor.book.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.callor.book.dao.ext.BookDao;
import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/book")
public class BookController {
	
	protected final BookService bookService;
	protected final BookDao bookDao;
	
	@RequestMapping(value="/insert/{isbn}", method = RequestMethod.GET)
	public String insert(@PathVariable("isbn") String isbn, Model model) throws Exception {
		
		log.debug("isbn : {}",isbn);
		int ret = bookService.insert(isbn);
		return "redirect:/book/list";
	}
	
	/*
	 * 통상적인 Spring Framework의 method에서는
	 * 
	 * view 파일의 이름을 String형으로 return하고
	 * view에서 랜더링할 데이터는 Model객체에 Attribute에 담아서 보내는 방식이다
	 * 
	 * ModelAndView 객체를 별도로 생성하여
	 * view는 setViewName() method를 이용해 setting하고
	 * 랜더링할 데이터는addObject() method를 이용해 추가하고
	 * MOdelAndView 객체를 return하는 방식도 사용한다.ㅣ
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		List<BookDTO> bookList = bookService.selectAll();
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		mv.addObject("MY_BOOKS",bookList);
		return mv;
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail() {
		
		// isbn을 받아서 도서 정보를 findByID()하고 자세히 보이기 위한 화면
		return "home";
	}
	

}
