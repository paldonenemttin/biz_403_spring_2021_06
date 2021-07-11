package com.team.statea.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.service.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("imageServiceV1")
public class ImageServiceImplV1 implements ImageService {

	@Qualifier("loader")
	private ResourceLoader loader;
	
	protected final String winPath;
	protected final String macPath;
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub

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
	
	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> fileNames = new ArrayList<String>();
		
		String tagName = "m_file";
		List<MultipartFile> imgList = files.getFiles(tagName);
		for(MultipartFile file : imgList) {
			String fileName = this.fileUp(file);
			fileNames.add(fileName);
		}
		return fileNames;
	}

	

	

}
