package com.callor.gallery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private int totalPages;

	// 리스트에서 필요한 데이터를 추출하기 위한 변수
	private int offset;
	private int limit;
}
