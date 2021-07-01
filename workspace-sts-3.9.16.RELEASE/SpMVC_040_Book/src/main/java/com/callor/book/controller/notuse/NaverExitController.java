package com.callor.book.controller.notuse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverGenericService;

//@Controller
@RestController
//@RequestMapping(value = "/naver")
public class NaverExitController {

	protected final NaverGenericService<BookDTO> nBookService;

	public NaverExitController(@Qualifier("NaverBookServiceV2") NaverGenericService<BookDTO> nBookService) {
		// TODO Auto-generated constructor stub
		this.nBookService = nBookService;
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<BookDTO> book(String search) throws MalformedURLException, IOException, ParseException {

		String queryURL = nBookService.URL(search);

		String jsonString = nBookService.getJsonString(queryURL);
		System.out.println(jsonString);
		List<BookDTO> bookList = nBookService.getNaverList(jsonString);
		return bookList;

	}

}
