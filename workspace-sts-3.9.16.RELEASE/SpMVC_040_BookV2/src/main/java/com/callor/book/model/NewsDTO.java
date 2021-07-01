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
public class NewsDTO {
	
	private String title;//	string	���� �˻� ����̸�, title, originallink, link, description, pubDate �� �����Ѵ�.
	private String originallink;//	string	�˻� ��� ������ ���� ��л� �������ؽ�Ʈ link�� ��Ÿ����.
	private String link;//	string	�˻� ��� ������ ���� ���̹� �������ؽ�Ʈ link�� ��Ÿ����.
	private String description;//	string	�˻� ��� ������ ������ ����� �н��� �����̴�. ���� ��ü�� ������ link�� ���󰡸� ���� �� �ִ�. �н������� �˻���� ��ġ�ϴ� �κ��� �±׷� ������ �ִ�.
	private String pubDate;//	datetime	�˻� ��� ������ ���̹��� ������ �ð��̴�.

}
