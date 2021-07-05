package com.callor.book.service.impl.news;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


@Service(NaverQuilifier.NAVER_NEWS_SERVICE_V1)
public class NaverNewsServiceImplV1 extends NaverAbstractService<NewsDTO> {

	@Override
	public String URL(String Search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String url = NaverSecret.URL.NewsURL;
		url += "?query%s&display=10";
		String searchUTF = URLEncoder.encode(Search, "UTF-8");
		url = String.format(url, searchUTF);
		return url;
	}

	@Override
	public List<NewsDTO> getNaverList(String jsonString) throws Exception{
		// TODO Auto-generated method stub
		
		JsonElement jsonElement = JsonParser.parseString(jsonString);

		JsonElement item = jsonElement.getAsJsonObject().get("items");

		Gson gson = new Gson();

		TypeToken<List<NewsDTO>> tToken = new TypeToken<List<NewsDTO>>() {};
		List<NewsDTO> newsList = gson.fromJson(item, tToken.getType());
		return newsList;
	}

}
