package com.callor.gallery.service;

import com.callor.gallery.model.PageDTO;

public interface PageService {
	
	public PageDTO makePageation(int totalList ,int currentPage);

}
