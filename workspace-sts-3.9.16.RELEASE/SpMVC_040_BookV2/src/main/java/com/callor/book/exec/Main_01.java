package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {

	public static void main(String[] args) {
		
		/*
		 * VO DTO를 생성하고 데이터를 담기
		 * 1. 빈(blank) 객체를 생성하고 필요한 값을
		 *  Setter를 사용해 지정하기
		 *  필요한 데이터 만큼 Setter method를 계속 나열해야 한다
		 */
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("자바야 놀자");
		
		// 2. 필드 생성자를 사용하여 객체를 생성하면서 값을 주입하는 방법
		// 일부데이터만 주입하여 객체를 생성 할 수 없다
		// 일부데이터를 위해 별도로 생성자를 또 만들어야 한다
		// 데이터의 주입순서가 바뀌면 어떤 값이 저장될지 모른다
		// 전적으로 개발자 책임으로 귀결된다
//		BookDTO bookDTO1 = new BookDTO("자바야 놀자", "link","image","author","discount","publisher","isbn","desc","pubdate", null);
		
		//3. Builder 패턴
		// 객체를 생성 초기화 할때 new 키워드를 사용않고 내부에 만들어진 builder() method를 먼저 호출
		// builder90 method는 객체를 생성하여 return하는 코드
		// 필요한 변수를 setting 할때
		// setter method를 사용 않고 변수명() 형태의 methdo를 사용해 값을 저장
		// 값이 저장되고 생성된 객체를 사용할 수 있도록 객체인스턴스(bookDTO2)에게 전달하기 위해 
		// build() method를 호출한다
		// 장점
		// new 키워드로 생성자를 호출하지 않는다
		// 필요한 변수(속서으, 맴버변수)만 가지고 있는 객체를 만들수 있다
		// 변수 이름을 직접 호출하는 방식으로 값을 저장할 수 있다
		//
		BookDTO bookDTO2 = BookDTO.builder().title("자바야 놀자").price("20000").isbn("9760000").build();
		System.out.println(bookDTO2.toString());
	}

}
