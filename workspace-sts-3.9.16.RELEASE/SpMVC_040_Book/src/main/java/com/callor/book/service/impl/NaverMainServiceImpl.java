package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverGenericService;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;

@Service("naverMainServiceV1")
@RequiredArgsConstructor
public class NaverMainServiceImpl {
	
	@Qualifier("NaverBookServiceV2")
	protected final NaverGenericService<BookDTO> nBookService;
	
	@Qualifier("NaverMovieServiceV1")
	protected final NaverMovieService nmService;
	
	public void naverGetData(String cat, String search, Model model) throws MalformedURLException, IOException, ParseException {
		
		if(search != null && !search.equals("")) {
			if(cat.equalsIgnoreCase("BOOK")) {
				// 도서
				String queryURL = nBookService.URL(search);
				String jsonString = nBookService.getJsonString(queryURL);
				System.out.println(jsonString);
				List<BookDTO> books = nBookService.getNaverList(jsonString);
				model.addAttribute("BOOKS", books);
				
			} else if(cat.equalsIgnoreCase("MOVIE")) {
				// 영화
				String queryURL = nmService.URL(search);
				String jsonString = nmService.getJsonString(queryURL);
				System.out.println(jsonString);
				List<MovieDTO> movies = nmService.getNaverList(jsonString);
				model.addAttribute("MOVIES", movies);
			} else if(cat.equalsIgnoreCase("NEWS")) {
				// 뉴스
			}
		}
		
	}
	
	

}
