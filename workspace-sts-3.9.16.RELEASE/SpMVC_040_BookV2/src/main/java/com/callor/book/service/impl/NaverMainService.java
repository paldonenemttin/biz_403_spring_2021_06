package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQuilifier.NAVER_MAIN_SERVICE_V1)
@RequiredArgsConstructor
public class NaverMainService {
	
	@Qualifier(NaverQuilifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	
	@Qualifier(NaverQuilifier.NAVER_MOVIE_SERVICE_V1)
	protected final  NaverAbstractService<MovieDTO> nmService;
	
	@Qualifier(NaverQuilifier.NAVER_NEWS_SERVICE_V1)
	protected final  NaverAbstractService<NewsDTO> nNService;
	
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
				log.debug("jsonString : {}",jsonString);
				
			} else if(cat.equalsIgnoreCase("NEWS")) {
				// 뉴스
				String queryURL = nmService.URL(search);
				String jsonString = nmService.getJsonString(queryURL);
				log.debug("jsonString : {}",jsonString);
			}
		}
		
	}
	
	

}
