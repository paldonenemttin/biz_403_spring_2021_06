package com.callor.book.service.impl.books;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.model.BookDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.TextFormat.ParseException;

import lombok.extern.slf4j.Slf4j;

/*
 * NaverBookServiceImplV1에서는 NaverAbstractService를 상속받았고
 * NaverBookServiceImplV2에서는 NaverBookServiceImplV1을 상속 받았다
 * 
 * NaverAbstractService nService = new NaverBookServiceImpl() 처럼 선언 및 생성 가능
 * 
 * NaverAbstractService 추상 클래스에 정의된 jsonStrign() method를 물려 받았고
 * NaverBookServiceImplV1 클래스에 정의된 URL() , getNaverList() method를 물려 받았다
 * 
 * 따라서 NaverBookServiceImplV2 클래스에는 URL(), jsonString(), getNaverList() method가 모두 있는 것과 같다
 */
 
@Slf4j
@Service(NaverQuilifier.NAVER_BOOK_SERVICE_V2)
public class NaverBookServiceImplV2 extends NaverBookServiceImplV1 {

	// gson을 사용해서 josnString을 parsing하기
	@Override
	public List<BookDTO> getNaverList(String jsonString) {
		
		log.debug("나는 V2");
		// 문자열형 JSON인 jSonString을 Json객체로 변환하기
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		
		// 필요한 항목만 가져오기
		JsonElement oItems = jsonElement.getAsJsonObject().get("items");
		
		Gson gson = new Gson();
		
		// List는 Interface인데 interface는
		// 자신의 type을 가지고 있지 않은 객체인데
		// Gson을 이용해 JSON parsing을 할때
		// List<DTO> 구조를 알수 있는 방법이 없어서
		// Gson의 특별한 객체 생성자를 하나 제공해주고
		// 이객체를 통해 list<DTO>의 구조를 알 수 있도록 만들어준다
		TypeToken<List<BookDTO>> typeToken = new TypeToken<List<BookDTO>>() {};
		
		List<BookDTO> bookList = gson.fromJson(oItems, typeToken.getType());
		
		return bookList;
	}
	
	

}
