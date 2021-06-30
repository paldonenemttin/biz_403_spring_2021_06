package com.team.statea.service;

import java.util.List;

import com.team.statea.model.dto.NoticeListDTO;
import com.team.statea.model.dto.NoticeViewDTO;

public interface NoticeService {
	
	public List<NoticeListDTO> selectList();
	public List<NoticeViewDTO> selectView();

}
