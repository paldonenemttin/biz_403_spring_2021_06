package com.callor.book.controller.notuse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverGenericService;

import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
//@RequestMapping("/book")
public class NaverBookController {

	@Qualifier("NaverBookServiceV2")
	protected final NaverGenericService<BookDTO> nBookService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(@RequestParam(name = "search", required = false, defaultValue = "") String search, Model model) throws MalformedURLException, IOException, ParseException {
//		model.addAttribute("pHolder", "���� �˻���");
		model.addAttribute("CAT", "BOOK");
		if (search != null && !search.equals("")) {

			String queryURL = nBookService.URL(search.trim());
			String jsonString = nBookService.getJsonString(queryURL);
			List<BookDTO> bookList = nBookService.getNaverList(jsonString);
			model.addAttribute("BOOKS", bookList);
		}
		return "home";
	}

	

}
