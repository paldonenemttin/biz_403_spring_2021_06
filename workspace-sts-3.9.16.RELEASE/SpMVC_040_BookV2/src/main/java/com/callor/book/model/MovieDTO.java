package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	
	private String title;//	string	�˻� ��� ��ȭ�� ������ ��Ÿ����. ���񿡼� �˻���� ��ġ�ϴ� �κ��� �±׷� ������ �ִ�.
	private String link;//	string	�˻� ��� ��ȭ�� �������ؽ�Ʈ link�� ��Ÿ����.
	private String image;//	string	�˻� ��� ��ȭ�� ����� �̹����� URL�̴�. �̹����� �ִ� ��츸 ��Ÿ����.
	private String subtitle;//	string	�˻� ��� ��ȭ�� ���� �����̴�.
	private String pubDate;//	date	�˻� ��� ��ȭ�� ���۳⵵�̴�.
	private String director;//	string	�˻� ��� ��ȭ�� �����̴�.
	private String actor;//	string	�˻� ��� ��ȭ�� �⿬ ����̴�.
	private String userRating;//integer	�˻� ��� ��ȭ�� ���� �������� �����̴�.

}
