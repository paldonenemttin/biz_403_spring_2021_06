package com.callor.book.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Naver News ������ ���� NewsDTOŬ������ list�� ������ �θ� DTO ����
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
	
	// naver���� �����Ͱ� ���۵Ǿ� �ö�
	// �ʿ��� �����ʹ� items�׸� �迭�� ��ܿ´�
	// �θ� DTO���� list type���� items ������ �����Ѵ�
	public List<NewsDTO> items;

}
