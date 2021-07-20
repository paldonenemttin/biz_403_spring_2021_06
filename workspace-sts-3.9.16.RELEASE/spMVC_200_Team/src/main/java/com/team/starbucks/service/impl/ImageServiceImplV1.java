package com.team.starbucks.service.impl;

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

import com.team.starbucks.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("imageServiceV1")
public class ImageServiceImplV1 implements ImageService {

	@Qualifier("loader")
	private ResourceLoader loader;
	
	protected final String winPath;
	protected final String macPath;
	
	protected String imagePath;
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub

		String originFileName = file.getOriginalFilename();
		if(originFileName == null || originFileName.isEmpty()) {
			return "";
		}
		/*
		 *  파일을 업도르할대 사용할 path가져오기
		 *  
		 *  1. 먼저 지정된 폴더를 윈도우 기반의 폴더로 설정
		 *  2. mac 기반의 폴더가 있으면 해당 폴더로 변경
		 */
		String fileUpPath = this.winPath;
		// 현재 시스템에 macPath로 설정된 폴더가 있는지 확인
		// 있으면 업로드 폴더를 macPath에 지정된 값으로 설정하기
		File path = new File(macPath);
		if(path.exists()) {
			fileUpPath = this.macPath;
		}
		
		// 다시한번 fileUpPath가 있는지 검사
		// winPath일 경우는 폴더를 만들어라
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

	@Override
	public int delete(String fileName) {
		// TODO Auto-generated method stub
		
		if(fileName == null || fileName.isEmpty()) {
			return 1;
		}
		File dropFile = new File(this.imagePath, fileName);
		
		if(dropFile.exists()) {
			boolean drop = dropFile.delete();
			if(drop) {
				return 1;
			}else {
				log.debug("실패");
				return -1;
			}
		}
		return 1;
	}

	

	

}
