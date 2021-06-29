package com.callor.book.service.impl;

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

import com.callor.book.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImplV1 implements NaverService<BookDTO> {

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


	@Override
	public String getJsonString(String URL) throws IOException {
		// TODO Auto-generated method stub
		// API를 통해 다른 서버에 Request를 보낼때 사용할 객체
		URL url = null;

		// Http 프로토콜을 통해 다른 서버에 연결할때 사용할 객체
		HttpURLConnection httpConn = null;

		// queryURL 주소를 Request 정보로 변환
		url = new URL(URL);

		// 생성된 URL 정보를 사용하여 다른 서버에 연결
		httpConn = (HttpURLConnection) url.openConnection();

		// 요청하는 method GET로 설정하기
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		// naver가 어떤 응답을 할것인지를 미리 확인하는 코드를 요청
		int httpStatusCode = httpConn.getResponseCode();

		// naver로 부터 데이터를 수신할 객체
		InputStreamReader is = null;
		if (httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			// 오류 처리
			is = new InputStreamReader(httpConn.getErrorStream());
		}
		// is를 buffer에 연결
		BufferedReader buffer = null;
		buffer = new BufferedReader(is);
		/*
		 * StringBuilder, StrignBuffer
		 * 
		 * String 형의 데이터를 += 처럼 사용할때 발생하는 memory leak, 성능저하 문제를 해결하기 위해 탄생된 클래스
		 * 
		 * String형의 데이터를 += 하면 예) 다음과 같은 코드를 반복하면 String str = "대한민국" str += "Korea" str
		 * += "Republic"
		 * 
		 * 내부적으로는 str변수를 생서으 제거, 생성, 제거, 생성하는 코드가 반복적으로 수행된다
		 * 
		 * 이러한 현상이 반복되면 메모리에 문제가 발생 하 ㄹ수 있다
		 * 
		 * 그러한 문제를 해결하기 위해 탄생한 클래스이다
		 * 
		 * 겉으로 보기에는 두 클래스의 역할, 사용법이 똑같다
		 * 
		 * StringBuilder는 Single Thread에서 최적화 되어있다 StringBuffer는 Multi Thread 에서 safe하다
		 */
		StringBuffer sBuffer = new StringBuffer();

		// 가져온 데이터를 읽어서 변수에 담기
		while (true) {
			String reader = buffer.readLine();
			if (reader == null) {
				break;
			}
			sBuffer.append(reader);
		}
		return sBuffer.toString();
	}

	/*
	 * 네이버에서 받은 JsonString을 parsing하여 List<BookDTO>에 담아서 return
	 * 
	 * JSON-simple을 사용하여 parsing하기
	 */
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub

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
