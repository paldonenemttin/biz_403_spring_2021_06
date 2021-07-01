package com.callor.book.service.impl.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.config.NaverSecret;
//import com.callor.book.config.NaverSecret_sample;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.extern.slf4j.Slf4j;

/*
 * naverAbstractService 추상 클래스르 상속받아 구현된 클래스
 * 추상 클래스에 사전 정의된 jsonStrign() method코드는 
 * 직접 작성 않고 사용가능
 * 		jsonString()
 * 추상메서드는 반드시 구현해야 함
 * 		URL(), getNaverList()
 * 
 * 아래와 같은 방법으로 사용 가능
 * NaverAbstractService nService = new NaverServiceImplV1()
 * nService.URL()
 * nService.jsonString()
 * nService.getNaverList()
 * 
 */
@Slf4j
@Service(NaverQuilifier.NAVER_BOOK_SERVICE_V1)
public class NaverBookServiceImplV1 extends NaverAbstractService<BookDTO> {

	/*
	 * naver에 요청하기 BookURL + "?query=" + 검색문자열
	 */

	public String URL(String search) {

		// 검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = null;
		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.URL.BookURL); // queryString += BookURL 알아서 빌딩 해줘서 이것만 써줘도 됌
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);

		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		log.debug("queryURL: {}", queryString);
		return queryURL.toString();
	}


	

	/*
	 * 네이버에서 받은 JsonString을 parsing하여 List<BookDTO>에 담아서 return
	 * 
	 * JSON-simple을 사용하여 parsing하기
	 */
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException  {
		// TODO Auto-generated method stub
		log.debug("나는 V1");
		List<BookDTO> bookList = new ArrayList<BookDTO>();

		// 1. json Parsing 도구 선언
		JSONParser jParser = new JSONParser();

		// JsonString을 JSON 객체로 변환
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		// parsing된 JSON객체에서 items항목을 추출하여
		// JSON 배열 타입으로 변환하기(내부적으로는 list타입)
		JSONArray items = (JSONArray) jObject.get("items");

		int nSize = items.size();
		for (int i = 0; i < nSize; i++) {
			// 한권의 도서 정보
			JSONObject item = (JSONObject) items.get(i);

			// 도서정보 항목을 문자열 변수에 저장
			String title = (String) item.get("title");
			String link = (String) item.get("link");
			String image = (String) item.get("image");
			String author = (String) item.get("author");
			String price = (String) item.get("price");
			String discount = (String) item.get("discount");
			String publisher = (String) item.get("publisher");
			String isbn = (String) item.get("isbn");
			String description = (String) item.get("description");
			String pubdate = (String) item.get("pubdate");

			// BookDTO에 담기
			BookDTO bookDTO = BookDTO.builder().title(title).link(link).image(image).author(author).price(price)
					.discount(discount).publisher(publisher).isbn(isbn).description(description).pubdate(pubdate)
					.build();
			// List에 add하기
			bookList.add(bookDTO);
		}

		return bookList;
	}

}
