package com.callor.jdbc.service;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorService {
	
	public List<AuthorVO> selectAll();

}
