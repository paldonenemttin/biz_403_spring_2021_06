package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping(value="/naver")
public class NaverController {
	
	protected final NaverService<BookDTO> nBookService;
	
	@RequestMapping(value= "/book" , method=RequestMethod.GET)
	public List<BookDTO> book(String search) throws MalformedURLException, IOException, ParseException {
		
		String queryURL = nBookService.URL(search);
		
		String jsonString = nBookService.getJsonString(queryURL);
		System.out.println(jsonString);
		List<BookDTO> bookList = nBookService.getNaverList(jsonString);
		return bookList;
		
	}

}
