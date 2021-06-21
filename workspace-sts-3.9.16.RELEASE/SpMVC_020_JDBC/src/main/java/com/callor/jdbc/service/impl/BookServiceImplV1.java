package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.BookService;

import lombok.RequiredArgsConstructor;

/*
 * �ʵ庯���� private final, protected final���� �����ϸ�
 * �ݵ�� �����ڿ��� �ش纯���� �ʱ�ȭ ���־�� �Ѵ�
 * �̶� �Ű������� ���� �ްų� ���� newŰ����� ������ �ϴµ�
 * 
 * Spring ������ newŰ���带 ��� �ʰ�
 * Spring Container�� ���� ���� �ޱ� ������
 * �ش� �����餷�� �Ű������� ���� �����ڰ� �ʿ��Ѵ�
 * 
 * �Ź� �����ڸ� ����� ���� ������ ���̰�
 * ������ �߰�, ���� �����Ҷ����� �����ڸ� �ٽ� �ڵ��ؾ� �ϴ� �������� �ִ�
 * 
 * �׷��� �ϵ� ��� �������ִ� lombok�� Annotation
 */
@RequiredArgsConstructor
@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService{

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
