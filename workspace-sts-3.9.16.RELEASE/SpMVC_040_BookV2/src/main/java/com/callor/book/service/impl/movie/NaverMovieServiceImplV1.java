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

import com.callor.book.config.NaverQuilifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQuilifier.NAVER_MOVIE_SERVICE_V1)
public class NaverMovieServiceImplV1 extends NaverAbstractService<MovieDTO>{

	@Override
	public String URL(String search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String url = NaverSecret.URL.MovieURL;
		url += "?query%s&display=10";
		String searchUTF = URLEncoder.encode(search,"UTF-8");
		url = String.format(url, searchUTF);
		
		log.debug("queryURL: {}", url);
		return url;
	}

	/*
	 * gSon을 사용해 jsonString을 List<MovieDTO)로 변환하기
	 */
	@Override
	public List<MovieDTO> getNaverList(String jsonString) {
		// TODO Auto-generated method stub
		
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		
		JsonElement item = jsonElement.getAsJsonObject().get("items");
		
		Gson gson = new Gson();
		
		TypeToken<List<MovieDTO>> tToken = new TypeToken<List<MovieDTO>>() {};
		List<MovieDTO> movieList = gson.fromJson(item, tToken.getType());
		return movieList;
	}

}
