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
 * abstract Ű���带 �߰��ϹǷν� �߻�Ŭ������ �ȴ�
 *
 * �߻� Ŭ����
 * �Ϲ����� ũ������ �������̽��� ������ ��� �����ϴ� Ŭ����
 * 
 * ����
 * 1. ��ӵǴ� �θ� Ŭ������ ���� 
 *      �����δ� ��ü�� ������ �� ����
 * 2. �߻�޼��带 �����ϴµ�
 * 		��ӹ��� �������� �ݵ�� �߻�޼��带 ����
 * 3. ��ӹ��� Ŭ�������� �ʿ��� ����ó�� method�� �Ϲ� Ŭ���� ó��
 * 		��ü������ �����ڵ带 ������ �ִ�
 * 4. ����ó�� method�� �ʿ信 ���� ��ӹ޴� ������ ������ �����ϴ�
 * 5. �������̽��� ������ ����
 * 		���� Ŭ������ ����(prototype)������ �����ϸ鼭
 * 		��ӹ��� Ŭ�����鿡 �������� �ʿ��� �ڵ带 �̸� ����
 * 
 * ��ü���� ��
 * �߻�Ŭ���� ��ü = new ��ӹ��� Ŭ����()
 * �������̽� ��ü = new impl Ŭ����()
 * �߻�Ŭ���� ��ü = new �߻� Ŭ����()�� ��� �Ұ�
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
