package com.team.statea.dao.ext;

import java.util.List;

import com.team.statea.dao.GenericDao;
import com.team.statea.model.BoardVO;
import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;

public interface BoardDao extends GenericDao<BoardVO, String> {
	
	public List<BoardListDTO> selectList();
	public BoardViewDTO selectView(String bd_code);
	public List<BoardListDTO> findSearch();
	public BoardViewDTO BoardDTOResultMap(String bd_code);

}
