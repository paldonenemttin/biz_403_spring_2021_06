package com.team.statea.service;

import java.util.List;

import com.team.statea.model.NoticeListDTO;
import com.team.statea.model.NoticeViewDTO;

public interface NoticeService {
	
	public List<NoticeListDTO> selectList();
	public List<NoticeViewDTO> selectView();

}
