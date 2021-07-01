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
 * naverAbstractService �߻� Ŭ������ ��ӹ޾� ������ Ŭ����
 * �߻� Ŭ������ ���� ���ǵ� jsonStrign() method�ڵ�� 
 * ���� �ۼ� �ʰ� ��밡��
 * 		jsonString()
 * �߻�޼���� �ݵ�� �����ؾ� ��
 * 		URL(), getNaverList()
 * 
 * �Ʒ��� ���� ������� ��� ����
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
	 * naver�� ��û�ϱ� BookURL + "?query=" + �˻����ڿ�
	 */

	public String URL(String search) {

		// �˻��ϰ��� �ϴ� ���ڿ��� UTF-8�� ���ڵ�
		String searchUTF8 = null;
		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.URL.BookURL); // queryString += BookURL �˾Ƽ� ���� ���༭ �̰͸� ���൵ ��
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);

		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		log.debug("queryURL: {}", queryString);
		return queryURL.toString();
	}


	

	/*
	 * ���̹����� ���� JsonString�� parsing�Ͽ� List<BookDTO>�� ��Ƽ� return
	 * 
	 * JSON-simple�� ����Ͽ� parsing�ϱ�
	 */
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException  {
		// TODO Auto-generated method stub
		log.debug("���� V1");
		List<BookDTO> bookList = new ArrayList<BookDTO>();

		// 1. json Parsing ���� ����
		JSONParser jParser = new JSONParser();

		// JsonString�� JSON ��ü�� ��ȯ
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		// parsing�� JSON��ü���� items�׸��� �����Ͽ�
		// JSON �迭 Ÿ������ ��ȯ�ϱ�(���������δ� listŸ��)
		JSONArray items = (JSONArray) jObject.get("items");

		int nSize = items.size();
		for (int i = 0; i < nSize; i++) {
			// �ѱ��� ���� ����
			JSONObject item = (JSONObject) items.get(i);

			// �������� �׸��� ���ڿ� ������ ����
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

			// BookDTO�� ���
			BookDTO bookDTO = BookDTO.builder().title(title).link(link).image(image).author(author).price(price)
					.discount(discount).publisher(publisher).isbn(isbn).description(description).pubdate(pubdate)
					.build();
			// List�� add�ϱ�
			bookList.add(bookDTO);
		}

		return bookList;
	}

}
