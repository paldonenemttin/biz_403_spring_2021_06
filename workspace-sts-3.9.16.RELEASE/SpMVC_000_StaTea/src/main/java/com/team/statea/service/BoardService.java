package com.team.statea.service;

import java.util.List;

import com.team.statea.model.BoardListDTO;
import com.team.statea.model.BoardViewDTO;

public interface BoardService {
	
	public List<BoardListDTO> selectList();
	public List<BoardViewDTO> selectView();

}
