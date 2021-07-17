package com.team.statea.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ImageService {
	
	public String fileUp(MultipartFile file)throws Exception;
	
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception;

	public int delete(String fileName);

}
