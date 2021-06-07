package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;

/*
 * Dao(Data Access Object)
 * Service -> Dao -> DBMS ��������
 * �������� �� table�� ���� CRUD�� ����� interface. class
 * Servlet project���� service�� �����ߴ� ������ 
 * Dao�� �����ϰ� �ȴ�
 */
public interface BookDao extends GenericDao<BookVO, String> {
	
	// Generic�� ����� method�� �߰��Ͽ� ���� ����
		// ���̺��� ��ȸ�� ���� method�� ����
		
		// ���������� �˻�
		public List<BookVO> findByName(String name);
		
		// �����Ϸ� �˻�
		public List<BookVO> findByDate(String date);
		
		public List<BookVO> findByComp(String comp);
		public List<BookVO> findByAuthor(String author);
	
	

}
