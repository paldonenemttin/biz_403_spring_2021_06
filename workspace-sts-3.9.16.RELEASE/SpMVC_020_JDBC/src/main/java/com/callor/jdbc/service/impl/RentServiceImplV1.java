package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Repository;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.RentService;

@Repository("rentV1")
public class RentServiceImplV1 implements RentService{

	protected final BookDao bookDao;
	protected final CompDao compDao;
	
	public RentServiceImplV1(BookDao bookDao, CompDao compDao) {
		// TODO Auto-generated constructor stub
		this.bookDao = bookDao;
		this.compDao = compDao;
	}
	@Override
	public void viewBookAndComp() {
		// TODO Auto-generated method stub
		bookDao.selectAll();
		compDao.selectAll();
		
	}

}
