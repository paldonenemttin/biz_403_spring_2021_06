package com.callor.book.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQuilifier;
import com.callor.book.dao.ext.BookDao;
import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImplV1 implements BookService{

	@Qualifier(NaverQuilifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	protected final BookDao bookDao;
	
	@Override
	public int insert(String isbnUTF) throws URISyntaxException, Exception {
		// TODO Auto-generated method stub
		String isbn = URLDecoder.decode(isbnUTF,"UTF-8");
		String[] isbns = isbn.split(" ");
		
		isbn = isbns[1];
		String queryURL = nBookService.URL(isbn);
		String jsonString = nBookService.getJsonString(queryURL);
		List<BookDTO> books = null;
		try {
			books = nBookService.getNaverList(jsonString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDTO book = books.get(0);
		book.setIsbn(isbn);
		bookDao.insert(book);		
		return 0;
	}

	@Override
	public List<BookDTO> selectAll() {
		// TODO Auto-generated method stub
		
		List<BookDTO> bookList = bookDao.selectAll();
		return bookList;
	}
	
	

}
