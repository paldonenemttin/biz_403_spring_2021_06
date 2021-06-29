package com.callor.book.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface NaverService<T> {
	
	
	
	// �˻� ���ڿ��� �޾Ƽ� �˻��� ���� url�� �����Ͽ� return
	public String URL(String search);
	
	// queryURl�� Naver�� ������
	// Naver�� ���� �����͸� json������ ���ڿ��� ����� return
	public String getJsonString(String URL) throws MalformedURLException, IOException;
	
	// json������ ���ڿ��� �޾Ƽ�
	// VCO�� ���� ����Ʈ Ÿ������ ����
	// �ó��� answkdufdmf parsing
	public List<T> getNaverList(String jsonString) throws ParseException;

}
