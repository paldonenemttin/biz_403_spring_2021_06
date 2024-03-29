package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;

/*
 * Dao(Data Access Object)
 * Service -> Dao -> DBMS 과정에서
 * 실질적인 한 table에 대한 CRUD를 담당할 interface. class
 * Servlet project에서 service가 실행했던 역할을 
 * Dao가 실행하게 된다
 */
public interface BookDao extends GenericDao<BookVO, String> {
	
	// Generic에 선언된 method에 추가하여 도서 정보
		// 테이블에서 조회할 여러 method를 지정
		
		// 도서명으로 검색
		public List<BookVO> findByName(String name);
		
		// 발행일로 검색
		public List<BookVO> findByDate(String date);
		
		public List<BookVO> findByComp(String comp);
		public List<BookVO> findByAuthor(String author);
	
	

}
