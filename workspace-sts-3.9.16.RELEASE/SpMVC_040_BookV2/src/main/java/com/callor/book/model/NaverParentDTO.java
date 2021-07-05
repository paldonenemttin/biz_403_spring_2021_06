package com.callor.book.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Naver News 정보를 담은 NewsDTO클래스를 list로 선언한 부모 DTO 선언
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverParentDTO {
	
	public String lastBuildDate;
	public String total;
	public String start;
	public String display;
	
	// naver에서 데이터가 전송되어 올때
	// 필요한 데이터는 items항목에 배열로 담겨온다
	// 부모 DTO에서 list type으로 items 변수를 선언한다
	public List<NewsDTO> items;

}
