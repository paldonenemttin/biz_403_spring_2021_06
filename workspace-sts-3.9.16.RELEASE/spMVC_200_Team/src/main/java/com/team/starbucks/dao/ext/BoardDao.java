package com.team.starbucks.dao.ext;

import java.util.List;

import com.team.starbucks.model.dto.BoardListDTO;
import com.team.starbucks.model.dto.BoardViewDTO;
import com.team.starbucks.dao.GenericDao;
import com.team.starbucks.model.BoardVO;

public interface BoardDao extends GenericDao<BoardVO, String> {
	
	public List<BoardListDTO> selectList();
	public BoardViewDTO selectView(String bd_code);
	public List<BoardViewDTO> findSearch();
	public BoardViewDTO selectBoardView(String bd_code);
	public int viewCount(String bd_code);
	public String getMaxCode();

}
