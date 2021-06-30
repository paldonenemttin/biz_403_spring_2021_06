package com.callor.book.service.impl.books;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.model.BookDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

/*
 * ServiceV1�� ��ӹ��� ServiceV2
 * Service interface�� ServiceV1�� ������ method �ڵ带 ��� �״�� ��ӹ޴´�
 * 
 * Service�� method
 * URL(), getJsonString(), getNaverList() �߿���
 * getNaverList() method�� ������ �Ϸ��� �Ѵ�
 * 
 * URL() , getJsonString() method�� �״�� ��� �޾� ����ϰ�
 * getNaverList()�� �ٽ� �ۼ��ϰڴ�
 * 
 * ServiceV1�� getNaverList�� json-simple�� �����
 * JSON parsing�� ������  �� List�� return�ϴ� �ڵ�
 * 
 * ServiceV2������ getNaverList() method�� �ٽ� �ۼ��Ͽ�
 * gson�� ����� JSON parsing�� �����ϴ� �ڵ�� �ۼ��ϱ�
 */
@Slf4j
@Service("NaverBookServiceV2")
public class NaverBookServiceImplV2 extends NaverBookServiceImplV1 {

	// gson�� ����ؼ� josnString�� parsing�ϱ�
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
		
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
