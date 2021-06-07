package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor // field 생성자
@NoArgsConstructor // super 생성자
public class BookVO {
	/*
	 * VO(DTO)를 설계할때
	 * 숫자형 변수는
	 * PK나 특별히 조회할때 사용하는 칼럼은
	 * class형(integer, Long, Float)로 선언하는 것이 좋다
	 * 이 칼럼이 null인 경우에 조건을 부여하여 연산하는데 유리하다
	 * 
	 * 일반적인 숫자형 변수는 primitive형으로 선언하는 것이 좋다
	 * 
	 * VO(DTO)클래스의 변수는 primitive로 선언하면
	 * 자동으로 0으로 초기화 된다
	 * 
	 * DB의 insert를 수행할때 해당 칼럼이 not null로 되어 있으면
	 * 별다른 처리르 하지 않아도 SQL exception이 발생하지 읺는다
	 */
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	private int bk_price; // integer로 선언할 경우 반드시 수동으로 =0 으로 초기화
	private int bk_pages;
}
