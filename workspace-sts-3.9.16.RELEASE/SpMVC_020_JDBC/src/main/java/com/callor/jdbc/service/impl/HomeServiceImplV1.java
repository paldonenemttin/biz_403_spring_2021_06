package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.service.AuthorService;
import com.callor.jdbc.service.BookService;
import com.callor.jdbc.service.CompService;
import com.callor.jdbc.service.HomeService;

@Service("homeServiceV1")
public class HomeServiceImplV1 implements HomeService {
	
	protected final BookService bkService = null;
	protected final CompService cpService = null;
	protected final AuthorService auService = null;
	
	@Override
	public void dashBoard(Model model) {
		// TODO Auto-generated method stub
		
		List<BookVO> bookList = bkService.selectAll();
		List<CompVO> compList = cpService.selectAll();
		List<AuthorVO> authorList = auService.selectAll();
		
		/*
		 * 
		 */
		model.addAttribute("AUTHORS", authorList);
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("COMPS",compList);
		
		
	}

}
