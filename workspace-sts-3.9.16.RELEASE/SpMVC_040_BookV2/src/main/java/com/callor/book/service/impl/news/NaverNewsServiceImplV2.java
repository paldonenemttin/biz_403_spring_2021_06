package com.callor.book.service.impl.news;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.NaverParentDTO;
import com.callor.book.model.NewsDTO;

import lombok.extern.slf4j.Slf4j;

/*
 * Spring framwork의 RestTemplate 클래스를 사용한 JSON parsing
 * 
 * json-simple Gson등을 사용할때는
 * OpenAPI를 통해 JsonString을 수신하고
 * parsing을 통해 DTO, List<DTO> 형태의 데이터롤 변환하는 과정을 수행했다
 * 
 * RestTemplate 를 사용하면 
 * DTO(VO)의 겹치는 구조를 잘 설계하고
 * 
 * 요청주소를 URI로 생성하고 인증정보등을 HttpHeaders 클래스로 하고
 * HttpEntity로 변환하여 HttpTemplate에 한다
 * 
 * 내부에서 요청정보를 Open Api로 보내고
 * 수신된 데이터를 DTO(VO) 구조에 따라 자체 parsing을 하고 결과를 돌려준다
 */
@Slf4j
@Service(NaverQuilifier.NAVER_NEWS_SERVICE_V2)
public class NaverNewsServiceImplV2 extends NaverNewsServiceImplV1 {

	@Override
	public List<NewsDTO> getNaverList(String URL) {
		// TODO Auto-generated method stub
		
		// spring framework 3.2에서 처음 도입된 클래스
		RestTemplate restTemp= new RestTemplate(); 
		
		ResponseEntity<NaverParentDTO> resList = null;
	/*
	 * json-simple, gson 등으로 parsing을 수행할땐
	 * URL 클래스를 사용해서 naver에 요청하고
	 * 결과를 jsonString으로 받았다
	 * 
	 * URI 클래스를 사용해 naver에 요청하는 정보를 생성하기 
	 * 내부적으로 인코딩드으이 문제를 없대기 위해
	 * URI을 사용하지 않고 URI를 사용한다	
	 */
		URI restURI = null;
		try {
			restURI = new URI(URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// naver에 요청할때 사용할 인증정보를 http protocal의 header에 부착
		HttpHeaders header = new HttpHeaders();
		header.set("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		header.set("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>("parameter",header);
									
		resList = restTemp.exchange(
				// naver에 요청할 URI 정보
				restURI, 
				// GET method로 확인
				HttpMethod.GET, 
				// 인증정보 등이 담긴 header
				entity, 
				// 내가 받을 data
				NaverParentDTO.class);
		
		log.debug("업데이트 날짜 : {}",resList.getBody().lastBuildDate);
		log.debug("전체 갯수 : {}",resList.getBody().total);
		log.debug("리스트 : {}",resList.getBody().items.toString());
		
		List<NewsDTO> newsList = resList.getBody().items;
		return newsList;
	}

}
