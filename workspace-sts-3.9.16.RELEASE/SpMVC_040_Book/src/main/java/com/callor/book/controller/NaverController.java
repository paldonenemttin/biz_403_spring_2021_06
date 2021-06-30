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
	 * web client에서 서버로 Request를 할때 어떤 데이터를 보내는 방법
	 * 
	 * 1. ?변수=값 : GET method 방법으로 queryString으로 데이터 보내기
	 *    ?username=callor&pw1234(가장 위험함)
	 *    
	 * 2. request Body에 담아 보내는 방식
	 *   <?form method=POST><input username>
	 *   
	 * 3. url Path(Path Variable)방식
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
