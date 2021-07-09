package com.callor.gallery.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GalleryDTO {

	/*
	 * ���� ������ �Խ����� ����� ���� Contents�� ������ table������ DTO�� ����
	 */
	private Long g_seq;// pk �ڵ� ����
	private String g_writer;// �ۼ���
	private String g_date;// �ۼ���
	private String g_time;// �ۼ��ð�
	private String g_subject;// ����
	private String g_content;// ����
	private String g_image;// ��ǥ �̹���
	
	// Gallery�� ������ FileList�� ���� List Type�� ������ �߰�
	//mapper���� collection���� ä�� ������
	List<FileDTO> fileList;
}
