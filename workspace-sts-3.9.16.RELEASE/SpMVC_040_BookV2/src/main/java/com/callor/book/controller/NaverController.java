package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BookDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.NaverMainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value="/naver")
public class NaverController {
	
	protected final NaverMainService nService;
//	protected final BookService mybookService;
	
	
	
	
	/*
	 * web client���� ������ Request�� �Ҷ� � �����͸� ������ ���
	 * 
	 * 1. ?����=�� : GET method ������� queryString���� ������ ������
	 *    ?username=callor&pw1234(���� ������)
	 *    
	 * 2. request Body�� ��� ������ ���
	 *   <?form method=POST><input username>
	 *   
	 * 3. url Path(Path Variable)���
	 *   http://localhost:8080/book/naver/namumu
	 *   http://localhost:8080/book/naver/namumu/aipro/1234
	 *   Mapping(value="/naver/{username}/{password}")
	 *    
	 */
	@RequestMapping(value="/{CAT}", method = RequestMethod.GET)
	public String home(@PathVariable(name = "CAT") String cat,@RequestParam(name = "search" , required = false, defaultValue = "") String search, Model model) throws Exception{
		model.addAttribute("CAT", cat);
		log.debug("URL :{}",cat);
		
//		List<BookDTO> myBookList = mybookService.selectAll();
//		model.addAttribute("MY_BOOKS",myBookList);
		
		nService.naverGetData(cat, search, model);
		return "home";
	}
	
	/*
	 * produces
	 * �Ϲ����� ���ڿ��� �ƴ� JSON ������ String�� ������
	 * ǥ���Ҷ� JSONŸ���� �ν��Ͽ� ������ ��� ���þ�
	 * �� ���þ �߰����� ������
	 * return type�� String�̱� ������ �ܼ� ���ڿ��� ó���� ������
	 */
	@ResponseBody
	@RequestMapping(value="/get/json", method = RequestMethod.GET , produces = "application/json;char=UTF-8")
	public String getJson() {
		String cat = "NEWS";
		String search ="butter";
		String jsonString = null;
		try {
			jsonString = nService.naverGetJsonString(cat, search);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value="/get/list")
	public List<NewsDTO> getNews(){
		
		nService.naver
	}
}
