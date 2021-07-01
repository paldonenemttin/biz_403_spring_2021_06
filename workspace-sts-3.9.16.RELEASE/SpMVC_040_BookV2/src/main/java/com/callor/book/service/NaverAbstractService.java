package com.callor.book.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.book.config.NaverSecret;



/*
 * abstract 키워드를 추가하므로써 추상클래스가 된다
 *
 * 추상 클래스
 * 일반적인 크랠스와 인터페이스의 성질을 모두 포함하는 클래스
 * 
 * 목적
 * 1. 상속되는 부모 클래스의 역할 
 *      스스로는 객체로 생성될 수 없다
 * 2. 추상메서드를 포함하는데
 * 		상속받은 곳에서는 반드시 추상메서드를 구현
 * 3. 상속받은 클래스들의 필요한 공통처리 method는 일반 클래스 처럼
 * 		자체적으로 구현코드를 가지고 있다
 * 4. 공통처리 method도 필요에 따라 상속받는 곳에서 재정의 가능하다
 * 5. 인터페이스의 역할을 수행
 * 		여러 클래스의 원형(prototype)역할을 수행하면서
 * 		상속받은 클래스들에 공토응로 필요한 코드를 미리 제공
 * 
 * 객체생성 법
 * 추상클래스 객체 = new 상속받은 클래스()
 * 인터페이스 객체 = new impl 클래스()
 * 추상클래스 객체 = new 추상 클래스()는 사용 불가
 */
public abstract class NaverAbstractService<T> {
	
	public abstract String URL(String Search) throws UnsupportedEncodingException;
	
	public String getJsonString(String URL) throws MalformedURLException, IOException {
		
		URL url = null;
		
		HttpURLConnection httpConn = null;
		
		url = new URL(URL);
		
		httpConn = (HttpURLConnection) url.openConnection();
		
		httpConn.setRequestMethod("GET");
		
		httpConn.setRequestProperty("X-Naver-Client-Id" , NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret" , NaverSecret.NAVER_CLIENT_SECRET);
		
		int httpSttCode = httpConn.getResponseCode();
		
		InputStreamReader ipread = null;
		if(httpSttCode == 200) {
			ipread = new InputStreamReader(httpConn.getInputStream(), "UTF-8"); 
		}else {
			ipread = new InputStreamReader(httpConn.getErrorStream());
		}
		
		BufferedReader buffer = null;
		buffer = new BufferedReader(ipread);
		
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String reader = buffer.readLine();
			if(reader == null) {
				break;
			}
			sb.append(reader);
		}
		return sb.toString();
	}
	
	public abstract List<T> getNaverList(String jsonString) throws ParseException;

}
