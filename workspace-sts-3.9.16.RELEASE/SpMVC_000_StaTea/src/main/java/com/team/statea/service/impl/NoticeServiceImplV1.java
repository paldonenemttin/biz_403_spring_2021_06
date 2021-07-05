package com.team.statea.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.statea.dao.ext.NoticeDao;
import com.team.statea.model.dto.NoticeListDTO;
import com.team.statea.model.dto.NoticeViewDTO;
import com.team.statea.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("noticeV1")
public class NoticeServiceImplV1 implements NoticeService{
	
	protected final NoticeDao ntDao;

	@Override
	public List<NoticeListDTO> selectList() {
		// TODO Auto-generated method stub
		
		List<NoticeListDTO> dtList = ntDao.selecList(); 
		return dtList;
	}

	@Override
	public List<NoticeViewDTO> selectView() {
		// TODO Auto-generated method stub
		List<NoticeViewDTO> nvList = ntDao.selectView();
		return nvList;
	}

	@Override
	public List<NoticeListDTO> searchList() {
		// TODO Auto-generated method stub
		
		List<NoticeListDTO> searchList = ntDao.findSearch();
		return searchList;
	}

}
