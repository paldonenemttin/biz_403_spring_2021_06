package com.callor.book.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
	
	@Qualifier(NaverQuilifier.NAVER_NEWS_SERVICE_V2)
	protected final  NaverAbstractService<NewsDTO> nNServiceV2;
	
	public void naverGetData(String cat, String search, Model model) throws MalformedURLException, IOException, ParseException, URISyntaxException {
		
		if(search != null && !search.equals("")) {
			if(cat.equalsIgnoreCase("BOOK")) {
				// ����
				String queryURL = nBookService.URL(search);
				String jsonString = nBookService.getJsonString(queryURL);
				System.out.println(jsonString);
				List<BookDTO> books = null;
				try {
					books = nBookService.getNaverList(jsonString);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("BOOKS", books);
				
			} else if(cat.equalsIgnoreCase("MOVIE")) {
				// ��ȭ
				String queryURL = nmService.URL(search);
				String jsonString = nmService.getJsonString(queryURL);
				log.debug("jsonString : {}",jsonString);
				try {
					List<MovieDTO> movieList = nmService.getNaverList(jsonString);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(cat.equalsIgnoreCase("NEWS")) {
				// ����
				/*
				 * queryURL�� �����ϰ�
				 * naver�� JSON String�� ��û�ϰ�
				 * Gson�� ����� parsing�Ͽ� LIst<NewsDTO>�� �����
				 * 
				 * queryURL�� �����ϰ�
				 * naver�� JSON String�� ��û�ϴ� ���
				 * (getJsonString())�� ������� �ʰڴ�
				 * getNavertList()
				 */
				String queryURL = nmService.URL(search);
				String jsonString = nmService.getJsonString(queryURL);
				log.debug("jsonString : {}",jsonString);
				try {
					List<NewsDTO> newsList = nNServiceV2.getNaverList(jsonString);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public String naverGetJsonString(String cat, String search) throws MalformedURLException, IOException {
		String queryURL = nNService.URL(search);
		String jsonString = nNService.getJsonString(queryURL);
		return jsonString;
	}
	
	

}
