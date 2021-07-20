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

	// 서버의 특별한 폴더에 접근하기 위해
	// 서버의 정보를 가져오기 위한 helper class
	@Autowired
	@Qualifier("resLoader")
	private ResourceLoader resLoader;
//	protected final ServletContext context;

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		// 파일 정보에서 파일이름 추출
		String originalFileName = file.getOriginalFilename();
		
		// 파일이 비어 있으면 null을 return
		if(originalFileName.isEmpty()) {
			return null;
		}
		
		log.debug("파일 이름 : {}", originalFileName);
		
		// context.xml에 설정된 files 정보를 가져오기
		Resource res = resLoader.getResource("/files");
		log.debug("get : {}", res.getURI().getPath());
		
		String filePath = res.getURI().getPath();
		
		/*
		 * file upload시 보안 주의
		 * 실제 파일이름으로 업로드를수행하면
		 * 쉽게 업로드 구현이 된다
		 * 
		 * 다만 만약 같은 이름의 파일을 중복해서 업로드하면
		 * 먼저 업로드된 파일이 변경되는 문제가 발생
		 * 
		 * 해커에 의해 같은 이름으로 파일들을 업로드 해버리면 저장된 원래 파일들이 모두 변조 될수 있다
		 * 
		 * 이런 문제를 방지하기 위해
		 * UUID 문자열을 생성하고
		 * UUID + 원래파일이름.원래 확장자 형식으로 업로드를 수행한다
		 * 이런 방식으로 파일을 저장하면 해킹의 위험을 막을 수 있다
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
