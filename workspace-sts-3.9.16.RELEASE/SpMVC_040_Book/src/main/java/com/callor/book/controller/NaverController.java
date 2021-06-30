package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.service.impl.NaverMainServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value="/naver")
public class NaverController {
	
	protected final NaverMainServiceImpl nService;
	
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
	public String home(@PathVariable(name = "CAT") String cat,@RequestParam(name = "search" , required = false, defaultValue = "") String search, Model model) throws MalformedURLException, IOException, ParseException {
		model.addAttribute("CAT", cat);
		log.debug("URL :{}",cat);
		
		nService.naverGetData(cat, search, model);
		return "home";
	}

}
