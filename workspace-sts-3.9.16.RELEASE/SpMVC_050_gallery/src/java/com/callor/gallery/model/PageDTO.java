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

	// ����Ʈ���� �ʿ��� �����͸� �����ϱ� ���� ����
	private int offset;
	private int limit;
}
