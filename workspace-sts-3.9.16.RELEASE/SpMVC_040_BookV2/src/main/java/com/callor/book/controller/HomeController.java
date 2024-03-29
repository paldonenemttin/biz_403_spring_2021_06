package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {

	@Qualifier(NaverQuilifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/naver/book";
	}
	@RequestMapping(value = "/not", method = RequestMethod.GET)
	public String home(@RequestParam(name = "category", required = false, defaultValue = "") String category, Model model) {
//		model.addAttribute("CAT", category);
		if(category.equalsIgnoreCase("BOOK")) {
			return "redirect:/book";
		}else if(category.equalsIgnoreCase("MOVIE")) {
			return "redirect:/movie";
		}else if(category.equalsIgnoreCase("NEWS")) {
			return "redirect:/news";
		} 
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home1(@RequestParam(name = "search", required = false, defaultValue = "") String search, Model model)
			throws Exception {

		if (search != null && !search.equals("")) {

			String queryURL = nBookService.URL(search.trim());
			String jsonString = nBookService.getJsonString(queryURL);
			List<BookDTO> bookList = nBookService.getNaverList(jsonString);
			model.addAttribute("BOOKS", bookList);
		}
		return "home";
	}
}
