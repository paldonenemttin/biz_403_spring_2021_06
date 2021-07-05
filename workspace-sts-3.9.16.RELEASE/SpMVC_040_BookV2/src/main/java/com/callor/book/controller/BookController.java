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
	 * ������� Spring Framework�� method������
	 * 
	 * view ������ �̸��� String������ return�ϰ�
	 * view���� �������� �����ʹ� Model��ü�� Attribute�� ��Ƽ� ������ ����̴�
	 * 
	 * ModelAndView ��ü�� ������ �����Ͽ�
	 * view�� setViewName() method�� �̿��� setting�ϰ�
	 * �������� �����ʹ�addObject() method�� �̿��� �߰��ϰ�
	 * MOdelAndView ��ü�� return�ϴ� ��ĵ� ����Ѵ�.��
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
		
		// isbn�� �޾Ƽ� ���� ������ findByID()�ϰ� �ڼ��� ���̱� ���� ȭ��
		return "home";
	}
	

}
