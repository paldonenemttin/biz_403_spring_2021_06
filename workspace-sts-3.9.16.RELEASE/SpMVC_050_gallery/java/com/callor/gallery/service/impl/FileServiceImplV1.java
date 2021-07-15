package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{

	// ������ Ư���� ������ �����ϱ� ����
	// ������ ������ �������� ���� helper class
	@Autowired
	@Qualifier("resLoader")
	private ResourceLoader resLoader;
//	protected final ServletContext context;

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		// ���� �������� �����̸� ����
		String originalFileName = file.getOriginalFilename();
		
		// ������ ��� ������ null�� return
		if(originalFileName.isEmpty()) {
			return null;
		}
		
		log.debug("���� �̸� : {}", originalFileName);
		
		// context.xml�� ������ files ������ ��������
		Resource res = resLoader.getResource("/files");
		log.debug("get : {}", res.getURI().getPath());
		
		String filePath = res.getURI().getPath();
		
		/*
		 * file upload�� ���� ����
		 * ���� �����̸����� ���ε带�����ϸ�
		 * ���� ���ε� ������ �ȴ�
		 * 
		 * �ٸ� ���� ���� �̸��� ������ �ߺ��ؼ� ���ε��ϸ�
		 * ���� ���ε�� ������ ����Ǵ� ������ �߻�
		 * 
		 * ��Ŀ�� ���� ���� �̸����� ���ϵ��� ���ε� �ع����� ����� ���� ���ϵ��� ��� ���� �ɼ� �ִ�
		 * 
		 * �̷� ������ �����ϱ� ����
		 * UUID ���ڿ��� �����ϰ�
		 * UUID + ���������̸�.���� Ȯ���� �������� ���ε带 �����Ѵ�
		 * �̷� ������� ������ �����ϸ� ��ŷ�� ������ ���� �� �ִ�
		 */
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;
		
		return strUUID;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> fileNames = new ArrayList<String>();
		String tagName = "m_file";
		
		List<MultipartFile> fileList = files.getFiles(tagName);
		for(MultipartFile file : fileList) {
			String fileName = this.fileUp(file);
			fileNames.add(fileName);
		}
		return fileNames;
	}

	@Override
	public int delete(String imgFileName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
