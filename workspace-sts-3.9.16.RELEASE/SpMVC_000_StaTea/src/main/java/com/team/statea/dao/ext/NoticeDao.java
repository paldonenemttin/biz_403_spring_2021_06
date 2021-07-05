package com.team.statea.dao.ext;

import java.util.List;

import com.team.statea.dao.GenericDao;
import com.team.statea.model.NoticeVO;
import com.team.statea.model.dto.NoticeListDTO;
import com.team.statea.model.dto.NoticeViewDTO;

public interface NoticeDao extends GenericDao<NoticeVO, String> {

	public List<NoticeListDTO> selecList();
	public List<NoticeViewDTO> selectView();
	public List<NoticeListDTO> findSearch();
	
}
