package com.team.statea.dao.ext;

import java.util.List;

import com.team.statea.dao.GenericDao;
import com.team.statea.model.BoardListDTO;
import com.team.statea.model.BoardVO;
import com.team.statea.model.BoardViewDTO;

public interface BoardDao extends GenericDao<BoardVO, String> {
	
	public List<BoardListDTO> selectList();
	public List<BoardViewDTO> selectView();

}
