package com.team.statea.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.model.BoardVO;
import com.team.statea.model.ImageVO;
import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;

public interface BoardService {
	
	public List<BoardListDTO> selectList();
	public BoardViewDTO selectView(String bd_code);
	public List<BoardViewDTO> searchList();
	public void insert(BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception;
	public int delete(String bd_code);
	public int viewCount(String bd_code);
	public void update(String bd_code, BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception;
	public int fileDelete(Long img_code);

}
