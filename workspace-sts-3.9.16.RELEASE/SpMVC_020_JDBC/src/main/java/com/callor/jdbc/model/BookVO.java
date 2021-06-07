package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor // field ������
@NoArgsConstructor // super ������
public class BookVO {
	/*
	 * VO(DTO)�� �����Ҷ�
	 * ������ ������
	 * PK�� Ư���� ��ȸ�Ҷ� ����ϴ� Į����
	 * class��(integer, Long, Float)�� �����ϴ� ���� ����
	 * �� Į���� null�� ��쿡 ������ �ο��Ͽ� �����ϴµ� �����ϴ�
	 * 
	 * �Ϲ����� ������ ������ primitive������ �����ϴ� ���� ����
	 * 
	 * VO(DTO)Ŭ������ ������ primitive�� �����ϸ�
	 * �ڵ����� 0���� �ʱ�ȭ �ȴ�
	 * 
	 * DB�� insert�� �����Ҷ� �ش� Į���� not null�� �Ǿ� ������
	 * ���ٸ� ó���� ���� �ʾƵ� SQL exception�� �߻����� �ݴ´�
	 */
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	private int bk_price; // integer�� ������ ��� �ݵ�� �������� =0 ���� �ʱ�ȭ
	private int bk_pages;
}
