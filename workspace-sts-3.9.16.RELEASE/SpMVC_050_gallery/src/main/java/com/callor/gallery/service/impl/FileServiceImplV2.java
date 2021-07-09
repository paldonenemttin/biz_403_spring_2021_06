package com.callor.gallery.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("fileServiceV2")
public class FileServiceImplV2 extends FileServiceImplV1{
	
	// file-context.xml�� ������ ������ ������
	protected final String winPath;
	protected final String macPath;
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		String originFileName = file.getOriginalFilename();
		if(originFileName == null || originFileName.isEmpty()) {
			return "";
		}
		/*
		 *  ������ �������Ҵ� ����� path��������
		 *  
		 *  1. ���� ������ ������ ������ ����� ������ ����
		 *  2. mac ����� ������ ������ �ش� ������ ����
		 */
		String fileUpPath = this.winPath;
		// ���� �ý��ۿ� macPath�� ������ ������ �ִ��� Ȯ��
		// ������ ���ε� ������ macPath�� ������ ������ �����ϱ�
		File path = new File(macPath);
		if(path.exists()) {
			fileUpPath = this.macPath;
		}
		
		// �ٽ��ѹ� fileUpPath�� �ִ��� �˻�
		// winPath�� ���� ������ ������
		path = new File(fileUpPath);
		if(path.exists()) {
			path.mkdirs();
		}
		
		
		String strUUID = UUID.randomUUID().toString();
		strUUID += originFileName;
		
		File uploadPathAndFile = new File(fileUpPath , strUUID);
		file.transferTo(uploadPathAndFile);
		
		return strUUID;
	}
	
	

}
