package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.BookService;

import lombok.RequiredArgsConstructor;

/*
 * 필드변수를 private final, protected final으로 선언하면
 * 반드시 생성자에서 해당변수를 초기화 해주어야 한다
 * 이때 매개변수로 전달 받거나 직접 new키워드로 생성을 하는데
 * 
 * Spring 에서는 new키워드를 사용 않고
 * Spring Container로 부터 주입 받기 때문에
 * 해당 변수들ㅇ르 매개변수로 갖는 생성자가 필요한다
 * 
 * 매번 생성자를 만드는 것이 귀찮은 일이고
 * 변수를 추가, 제거 변경할때마다 생성자를 다시 코딩해야 하는 불편함이 있다
 * 
 * 그러한 일들 대신 수행해주는 lombok의 Annotation
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
