package com.callor.book.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.book.model.BookDTO;

public interface BookService {

	public int insert(String isbn) throws UnsupportedEncodingException, MalformedURLException, IOException, ParseException, URISyntaxException, Exception;
	
	public List<BookDTO> selectAll();

}
