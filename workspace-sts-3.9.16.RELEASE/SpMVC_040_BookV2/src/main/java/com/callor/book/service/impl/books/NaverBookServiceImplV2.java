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
 * NaverBookServiceImplV1������ NaverAbstractService�� ��ӹ޾Ұ�
 * NaverBookServiceImplV2������ NaverBookServiceImplV1�� ��� �޾Ҵ�
 * 
 * NaverAbstractService nService = new NaverBookServiceImpl() ó�� ���� �� ���� ����
 * 
 * NaverAbstractService �߻� Ŭ������ ���ǵ� jsonStrign() method�� ���� �޾Ұ�
 * NaverBookServiceImplV1 Ŭ������ ���ǵ� URL() , getNaverList() method�� ���� �޾Ҵ�
 * 
 * ���� NaverBookServiceImplV2 Ŭ�������� URL(), jsonString(), getNaverList() method�� ��� �ִ� �Ͱ� ����
 */
 
@Slf4j
@Service(NaverQuilifier.NAVER_BOOK_SERVICE_V2)
public class NaverBookServiceImplV2 extends NaverBookServiceImplV1 {

	// gson�� ����ؼ� josnString�� parsing�ϱ�
	@Override
	public List<BookDTO> getNaverList(String jsonString) {
		
		log.debug("���� V2");
		// ���ڿ��� JSON�� jSonString�� Json��ü�� ��ȯ�ϱ�
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		
		// �ʿ��� �׸� ��������
		JsonElement oItems = jsonElement.getAsJsonObject().get("items");
		
		Gson gson = new Gson();
		
		// List�� Interface�ε� interface��
		// �ڽ��� type�� ������ ���� ���� ��ü�ε�
		// Gson�� �̿��� JSON parsing�� �Ҷ�
		// List<DTO> ������ �˼� �ִ� ����� ���
		// Gson�� Ư���� ��ü �����ڸ� �ϳ� �������ְ�
		// �̰�ü�� ���� list<DTO>�� ������ �� �� �ֵ��� ������ش�
		TypeToken<List<BookDTO>> typeToken = new TypeToken<List<BookDTO>>() {};
		
		List<BookDTO> bookList = gson.fromJson(oItems, typeToken.getType());
		
		return bookList;
	}
	
	

}
