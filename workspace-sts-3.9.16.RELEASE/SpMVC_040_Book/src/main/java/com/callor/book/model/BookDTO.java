package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

/*
 * builder ������ ����� �� �ֵ��� �����ϴ� Annotation
 * Builder voxjs : GoF���� 
 */
@Builder

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	private String title;//	string	�˻� ��� ������ ������ ��Ÿ����. ���񿡼� �˻���� ��ġ�ϴ� �κ��� �±׷� ������ �ִ�.
	private String link;//	string	�˻� ��� ������ �������ؽ�Ʈ link�� ��Ÿ����.
	private String image;//	string	����� �̹����� URL�̴�. �̹����� �ִ� ��츸 ��Ÿ������.
	private String author;//	string	���� �����̴�.
	private String price;//	integer	���� �����̴�. ���ǵ��� ������ ������ ������ ��Ÿ���� �ʴ´�.
	private String discount;//	integer	���� ���� �����̴�. ���ǵ��� ������ ������ ������ ��Ÿ���� �ʴ´�.
	private String publisher;//	string	���ǻ� �����̴�.
	private String isbn;//	integer	ISBN �ѹ��̴�.
	private String description;//	string	�˻� ��� ������ ������ ����� �н��� �����̴�. ���� ��ü�� ������ link�� ���󰡸� ���� �� �ִ�. �н������� �˻���� ��ġ�ϴ� �κ��� �±׷� ������ �ִ�.
	private String pubdate;//	datetime	�Ⱓ�� �����̴�.

}
