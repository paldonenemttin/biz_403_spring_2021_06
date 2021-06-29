package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {

	public static void main(String[] args) {
		
		/*
		 * VO DTO�� �����ϰ� �����͸� ���
		 * 1. ��(blank) ��ü�� �����ϰ� �ʿ��� ����
		 *  Setter�� ����� �����ϱ�
		 *  �ʿ��� ������ ��ŭ Setter method�� ��� �����ؾ� �Ѵ�
		 */
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("�ڹپ� ����");
		
		// 2. �ʵ� �����ڸ� ����Ͽ� ��ü�� �����ϸ鼭 ���� �����ϴ� ���
		// �Ϻε����͸� �����Ͽ� ��ü�� ���� �� �� ����
		// �Ϻε����͸� ���� ������ �����ڸ� �� ������ �Ѵ�
		// �������� ���Լ����� �ٲ�� � ���� ������� �𸥴�
		// �������� ������ å������ �Ͱ�ȴ�
//		BookDTO bookDTO1 = new BookDTO("�ڹپ� ����", "link","image","author","discount","publisher","isbn","desc","pubdate", null);
		
		//3. Builder ����
		// ��ü�� ���� �ʱ�ȭ �Ҷ� new Ű���带 ���ʰ� ���ο� ������� builder() method�� ���� ȣ��
		// builder90 method�� ��ü�� �����Ͽ� return�ϴ� �ڵ�
		// �ʿ��� ������ setting �Ҷ�
		// setter method�� ��� �ʰ� ������() ������ methdo�� ����� ���� ����
		// ���� ����ǰ� ������ ��ü�� ����� �� �ֵ��� ��ü�ν��Ͻ�(bookDTO2)���� �����ϱ� ���� 
		// build() method�� ȣ���Ѵ�
		// ����
		// new Ű����� �����ڸ� ȣ������ �ʴ´�
		// �ʿ��� ����(�Ӽ���, �ɹ�����)�� ������ �ִ� ��ü�� ����� �ִ�
		// ���� �̸��� ���� ȣ���ϴ� ������� ���� ������ �� �ִ�
		//
		BookDTO bookDTO2 = BookDTO.builder().title("�ڹپ� ����").price("20000").isbn("9760000").build();
		System.out.println(bookDTO2.toString());
	}

}
