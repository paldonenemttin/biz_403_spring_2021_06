package com.callor.book.service.impl.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.List;

import java.net.URL;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("NaverMovieServiceV1")
public class NaverMovieServiceImplV1 implements NaverMovieService{

	@Override
	public String URL(String search) {
		// TODO Auto-generated method stub
		String searchUTF8 = null;
		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.URL.MovieURL);
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);
		
		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		log.debug("queryURL: {}", queryString);
		return queryURL.toString();
	}

	@Override
	public String getJsonString(String URL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
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

	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		
		JsonElement item = jsonElement.getAsJsonObject().get("item");
		
		Gson gson = new Gson();
		
		TypeToken<List<MovieDTO>> tToken = new TypeToken<List<MovieDTO>>() {};
		List<MovieDTO> movieList = gson.fromJson(item, tToken.getType());
		return movieList;
	}

}
