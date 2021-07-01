package com.callor.book.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/*
 * REstFull Service
 * API Service
 * request�� ���Ͽ� view(*.jsp, *.html)���� �������� �ʰ�
 * ��ӵ� �����͸� Response�ϴ� ����
 * 
 * ���� view�� return���� �ʴ´�
 * return�Ǵ� ������ type���� �����͸� response�Ѵ�
 * �ַ� String, JSON(List,VO,DTO)�������� response�Ѵ�
 */
@RestController
@Slf4j
@RequestMapping(value="/api")
public class APIController {
	
	@RequestMapping(value= {"/",""},method = RequestMethod.GET)
	public String home() {
		return "Republic of Korea";
	}
	
	/*
	 * Ajax ���� ���۵Ǿ�� ������ �ޱ�
	 * Ajax POST�� ���۵� �����ʹ� Request�� body(PayLoad)�� ��ܼ�
	 * ���޵Ǿ� �´�
	 * �Ϲ����� JSP(form, link)���� ���� �����ʹ� �Ű������� ���� 
	 * ���� ���� ���� �� �ִµ� Ajax�� ���� ���� �����ʹ� �׷��� ���ϴ�
	 * ������ 1���� ������ ��� �����Ͱ� JSON ���ڿ� ���·� �޾�����
	 * 
	 * JSON ���ڿ��� JSON, ��ü �������� ��ȯ(parsing)�ؾ� �ϴ� ������ �����Ѵ�
	 * 
	 * Spring���� Ajax�� ���۵� �����ʹ� ������ Map���� �޴´�
	 * �׸��� �Ű������� @RequestBody�� �ݵ�� ������ �д�
	 * 
	 * ����
	 * pom.xml�� jackson-databind Dependency�� �ݵ�� �����صд�
	 */
	@RequestMapping(value={"/",""} , method = RequestMethod.POST)
	public String reqAjax(@RequestBody Map<String, String> maps) {
		log.debug("Maps : {}", maps.toString());
		log.debug("search : {}", maps.get("search"));
		log.debug("seach : {}", maps.get("st_name"));
		return "ok";
	}

}
