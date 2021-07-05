package com.team.statea.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.statea.dao.ext.BoardDao;
import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;
import com.team.statea.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("boardV1")
public class BoardServiceImplV1 implements BoardService{

	protected final BoardDao bdDao;
	
	@Override
	public List<BoardListDTO> selectList() {
		// TODO Auto-generated method stub
		List<BoardListDTO> liList = bdDao.selectList();
		return liList;
	}

	@Override
	public List<BoardViewDTO> selectView() {
		// TODO Auto-generated method stub
		List<BoardViewDTO> viewList = bdDao.selectView();
		return viewList;
	}

	@Override
	public List<BoardListDTO> searchList() {
		// TODO Auto-generated method stub
		List<BoardListDTO> schList = bdDao.findSearch();
		return schList;
	}

}
