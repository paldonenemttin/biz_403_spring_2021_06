package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	/*
	 * RequestMethod
	 * GET:(SELECT)  ��ȸ - a tag�� link Ŭ��
	 * POST:(INSERT) �߰� - form�� ���� �Է��Ͽ� ������ ������
	 * 
	 * RESTfell HTTP Server���� �߰��Ͽ� ���
	 * PUT: (UPDATE) ����
	 * DELETE: (DELETE)����
	 * 
	 * RequestMapping�� ���� , requsetMethod�� ���� ���� ���� ��� �ʴ´�
	 * 
	 * requestMapping�� ������ RequestMapping�� �ٸ��� ���� ��� �� �� �ִ�.
	 * 
	 * GET method ������� form�� ��� �����͸� �����Ҷ�
	 * http://localhost:8080/hello/insert?name=ȫ�浿&tel=010-2345-6789
	 * - �����ϴ� �����Ͱ� HTTP���������� body�� ��ܼ�
	 * ���۵Ǳ� ������ �����Ͱ� ���� ���ߵ� �� �ִ�
	 * - ��ü uri�� ���̰� 256byte�� �Ѿ��
	 * �����Ͱ� �ڸ��� ������ �߻��Ѵ�
	 * 
	 * POST method ������� form�� ��� �����͸� �����Ҷ�
	 * http://localhost:8080/hello/insert
	 * - �����ϴ� �����Ͱ� http���������� body�� ��ܼ� ���۵��� �ʱ� ������
	 * �ּ�â� ������� �ʴ´�
	 * - �̷л����δ� �����ϴ� �������� ũ�⿡ ������ ����
	 * �ٸ�, �̹����� ���� ū �����͸� �����ϰ� �Ǹ�
	 * ��Ʈ��ũ�� ������ �޻��� �� �־ �������� �Ϻ� ũ�⸦ �����ϱ⵵ �Ѵ�
	 * 
	 * ���� ���忡��
	 * GET : http://localhost:8080/hello/insert?name=""���� ��û�� ������
	 * @RequestMapping(value = "/insert" , method = GET)�� ó���ϴ� method�� �־�� ������
	 * 
	 * Mapping(value = "/insert")�� �ִµ�
	 * method=post�� ���� ��� ������ 405 http �����ڵ带 �����Ѵ�
	 */
	
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public void my() {
		
	}
	
	// insert uri mapping�� post������� ��û�� ó�� �ϰڴ�
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public void insert() {
		
	}
	
	/*
	 * Spring������ Web���κ��� ���޹��� �����͸� Java method�� �Ű������� �����Ͽ� ���� �� �ִ�
	 * 
	 * String framework ���ο��� reflection�̶�� �ڵ尡 �۵��Ǿ
	 * ���޹��� ���� �̸��� java method�� �Ű������� �̸���Ī ������� ������ �޴´�
	 * �̷� �ڵ�� �����ڰ� �Ű澲�� �ʾƵ� �ڵ����� �۵��ȴ� �ڵ�
	 * getParameter()���� �ڵ带 ������ �ؾ �ȴ�
	 * 
	 * �׷���,
	 * Java method ������ String���� �ƴ� ������ ������ boolean����
	 * ������ �ϸ� reflection�� ����ȴ� ���ȿ� String �� �����͸�
	 * ������ ������ Ÿ������ �� ��ȯ ������ ����ȴ�
	 * �̰������� ����ȯ�� Exception�� �߻��ϸ�
	 * Reflection �ڵ尡 �ߴܵǰ�
	 * Spring Dispatcher��  Web 400 Status code�� �����ع�����
	 * 
	 * ���� ��ü������ � ������ �߻��ߴ��� �˷����� �ʴ´�
	 */
	// insert uri mapping�� get������� ��û�� ó�� �ϰڴ�
	@RequestMapping(value = "/insert" , method = RequestMethod.GET)
	public void insert(String dummy, int num) {
		
		Integer.valueOf(dummy);
//		String strNum = "300A";
//		// NumberFormat Exception
//		Integer intNum = Integer.valueOf(strNum);
	}

}
