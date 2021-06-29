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


	@Override
	public String getJsonString(String URL) throws IOException {
		// TODO Auto-generated method stub
		// API�� ���� �ٸ� ������ Request�� ������ ����� ��ü
		URL url = null;

		// Http ���������� ���� �ٸ� ������ �����Ҷ� ����� ��ü
		HttpURLConnection httpConn = null;

		// queryURL �ּҸ� Request ������ ��ȯ
		url = new URL(URL);

		// ������ URL ������ ����Ͽ� �ٸ� ������ ����
		httpConn = (HttpURLConnection) url.openConnection();

		// ��û�ϴ� method GET�� �����ϱ�
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		// naver�� � ������ �Ұ������� �̸� Ȯ���ϴ� �ڵ带 ��û
		int httpStatusCode = httpConn.getResponseCode();

		// naver�� ���� �����͸� ������ ��ü
		InputStreamReader is = null;
		if (httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			// ���� ó��
			is = new InputStreamReader(httpConn.getErrorStream());
		}
		// is�� buffer�� ����
		BufferedReader buffer = null;
		buffer = new BufferedReader(is);
		/*
		 * StringBuilder, StrignBuffer
		 * 
		 * String ���� �����͸� += ó�� ����Ҷ� �߻��ϴ� memory leak, �������� ������ �ذ��ϱ� ���� ź���� Ŭ����
		 * 
		 * String���� �����͸� += �ϸ� ��) ������ ���� �ڵ带 �ݺ��ϸ� String str = "���ѹα�" str += "Korea" str
		 * += "Republic"
		 * 
		 * ���������δ� str������ ������ ����, ����, ����, �����ϴ� �ڵ尡 �ݺ������� ����ȴ�
		 * 
		 * �̷��� ������ �ݺ��Ǹ� �޸𸮿� ������ �߻� �� ���� �ִ�
		 * 
		 * �׷��� ������ �ذ��ϱ� ���� ź���� Ŭ�����̴�
		 * 
		 * ������ ���⿡�� �� Ŭ������ ����, ������ �Ȱ���
		 * 
		 * StringBuilder�� Single Thread���� ����ȭ �Ǿ��ִ� StringBuffer�� Multi Thread ���� safe�ϴ�
		 */
		StringBuffer sBuffer = new StringBuffer();

		// ������ �����͸� �о ������ ���
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
	 * ���̹����� ���� JsonString�� parsing�Ͽ� List<BookDTO>�� ��Ƽ� return
	 * 
	 * JSON-simple�� ����Ͽ� parsing�ϱ�
	 */
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub

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
