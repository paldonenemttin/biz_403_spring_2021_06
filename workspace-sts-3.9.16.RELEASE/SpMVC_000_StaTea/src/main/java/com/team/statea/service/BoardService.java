package com.team.statea.service;

import java.util.List;

import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;

public interface BoardService {
	
	public List<BoardListDTO> selectList();
	public List<BoardViewDTO> selectView();
	public List<BoardListDTO> searchList();

}
