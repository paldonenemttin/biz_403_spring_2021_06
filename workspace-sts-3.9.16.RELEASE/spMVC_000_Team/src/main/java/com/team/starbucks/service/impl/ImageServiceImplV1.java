package com.team.starbucks.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.starbucks.service.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("imageV1")
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
		if (originFileName == null || originFileName.isEmpty()) {
			return "";
		}

		String fileUpPath = this.winPath;

		File path = new File(macPath);
		if (path.exists()) {
			fileUpPath = this.macPath;
		}

		path = new File(fileUpPath);
		if (path.exists()) {
			path.mkdirs();
		}

		String strUUID = UUID.randomUUID().toString();
		strUUID += originFileName;

		File uploadPathAndFile = new File(fileUpPath, strUUID);
		file.transferTo(uploadPathAndFile);

		return strUUID;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		List<String> fileNames = new ArrayList<String>();

		String tagName = "m_file";
		List<MultipartFile> imgList = files.getFiles(tagName);
		for (MultipartFile file : imgList) {
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
				
				return -1;
			}
		}
		return 1;
	}

}
