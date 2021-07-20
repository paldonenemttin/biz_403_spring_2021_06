package com.callor.gallery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GalleryFilesDTO {
	
	/*
	 * tbl_gallery�� tbl_files table�� join�Ͽ� select�� �����ʹ� ������ 1:N ����� ������ ����̴�
	 * 
	 * ������ ���� �������� list�� ��ġ tbl_gallery�� ������ �ִ� ��ó�� ���δ�
	 * 
	 * ex) gallery 1�� �����Ϳ� file�� 3�� ÷�ε� ��� �������� ����Ʈ�� ������ ����
	 * *********************************
	 * 1�� gallery 1�� ����
	 * 1�� gallery 2�� ����
	 * 1�� gallery 3�� ����
	 * *********************************
	 * ������ gallery�� 1�� ������ ����� �����ʹ� ��ü�� list�̹Ƿ�
	 * ��ü view�� ���� DTO�� �����ϰ� List<DTO>�� ������ �����͸� ��Ҵ�
	 * 
	 * ���� �����Ϳ� ��� ���� g_seq��� gallery ������ ���� ��������
	 * �Ѱ��� ������ �� ���� file ���� ��ŭ ������ �����ϴ� ����� �ȴ�
	 */
	
	private Long g_seq; //	bigint
	private String g_writer;//	varchar(120)
	private String g_date;//	varchar(10)
	private String g_time;//	varchar(10)
	private String g_subject;//	varchar(50)
	private String g_content;//	varchar(1000)
	private String g_image;//	varchar(256)
	private Long f_seq;//	bigint
	private String f_origin;//	varchar(256)
	private String f_upname;//	varchar(256)

}
