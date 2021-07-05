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
 * Spring framwork�� RestTemplate Ŭ������ ����� JSON parsing
 * 
 * json-simple Gson���� ����Ҷ���
 * OpenAPI�� ���� JsonString�� �����ϰ�
 * parsing�� ���� DTO, List<DTO> ������ �����ͷ� ��ȯ�ϴ� ������ �����ߴ�
 * 
 * RestTemplate �� ����ϸ� 
 * DTO(VO)�� ��ġ�� ������ �� �����ϰ�
 * 
 * ��û�ּҸ� URI�� �����ϰ� ������������ HttpHeaders Ŭ������ �ϰ�
 * HttpEntity�� ��ȯ�Ͽ� HttpTemplate�� �Ѵ�
 * 
 * ���ο��� ��û������ Open Api�� ������
 * ���ŵ� �����͸� DTO(VO) ������ ���� ��ü parsing�� �ϰ� ����� �����ش�
 */
@Slf4j
@Service(NaverQuilifier.NAVER_NEWS_SERVICE_V2)
public class NaverNewsServiceImplV2 extends NaverNewsServiceImplV1 {

	@Override
	public List<NewsDTO> getNaverList(String URL) {
		// TODO Auto-generated method stub
		
		// spring framework 3.2���� ó�� ���Ե� Ŭ����
		RestTemplate restTemp= new RestTemplate(); 
		
		ResponseEntity<NaverParentDTO> resList = null;
	/*
	 * json-simple, gson ������ parsing�� �����Ҷ�
	 * URL Ŭ������ ����ؼ� naver�� ��û�ϰ�
	 * ����� jsonString���� �޾Ҵ�
	 * 
	 * URI Ŭ������ ����� naver�� ��û�ϴ� ������ �����ϱ� 
	 * ���������� ���ڵ������� ������ ����� ����
	 * URI�� ������� �ʰ� URI�� ����Ѵ�	
	 */
		URI restURI = null;
		try {
			restURI = new URI(URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// naver�� ��û�Ҷ� ����� ���������� http protocal�� header�� ����
		HttpHeaders header = new HttpHeaders();
		header.set("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		header.set("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>("parameter",header);
									
		resList = restTemp.exchange(
				// naver�� ��û�� URI ����
				restURI, 
				// GET method�� Ȯ��
				HttpMethod.GET, 
				// �������� ���� ��� header
				entity, 
				// ���� ���� data
				NaverParentDTO.class);
		
		log.debug("������Ʈ ��¥ : {}",resList.getBody().lastBuildDate);
		log.debug("��ü ���� : {}",resList.getBody().total);
		log.debug("����Ʈ : {}",resList.getBody().items.toString());
		
		List<NewsDTO> newsList = resList.getBody().items;
		return newsList;
	}

}
