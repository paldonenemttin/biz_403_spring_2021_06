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
	 * 일반적인 문자열이 아닌 JSON 형태의 String을 보내니
	 * 표시할때 JSON타입을 인식하여 보여라 라는 지시어
	 * 이 지시어를 추가하지 않으면
	 * return type이 String이기 때문에 단순 문자열로 처리해 버린디
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
