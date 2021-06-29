package com.callor.book.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface NaverService<T> {
	
	
	
	// 검색 문자열을 받아서 검색을 위한 url을 생성하여 return
	public String URL(String search);
	
	// queryURl을 Naver에 보내고
	// Naver가 보낸 데이터를 json형태의 문자열로 만들어 return
	public String getJsonString(String URL) throws MalformedURLException, IOException;
	
	// json형태의 문자열을 받아서
	// VCO를 담은 리스트 타입으로 리던
	// ㅓ내ㅜ answkdufdmf parsing
	public List<T> getNaverList(String jsonString) throws ParseException;

}
