package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	
	// 1���� ������ ���ε��ϰ� ���� �̸��� return
	public String fileUp(MultipartFile file) throws Exception;
	// �ټ��� ������ ���ε��ϰ� ���� �̸��� return
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception;
	// ÷�ε� ������ �����ϱ� ���� method
	public int delete(String imgFileName);

}
