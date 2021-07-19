package com.team.statea.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.dao.ext.BoardDao;
import com.team.statea.dao.ext.ImageDao;
import com.team.statea.model.BoardVO;
import com.team.statea.model.ImageVO;
import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;
import com.team.statea.service.BoardService;
import com.team.statea.service.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("boardV1")
public class BoardServiceImplV1 implements BoardService {

	protected final BoardDao bdDao;

	protected final ImageDao imgDao;

	protected final ImageService imgService;

	@Override
	public List<BoardListDTO> selectList() {
		// TODO Auto-generated method stub
		List<BoardListDTO> liList = bdDao.selectList();
		return liList;
	}

	@Override
	public List<BoardViewDTO> searchList() {
		// TODO Auto-generated method stub
	
		return  bdDao.findSearch();
	}

	@Override
	public void insert(BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		// TODO Auto-generated method stub
		bdDao.insert(boardVO);
		String bd_code = boardVO.getBd_code();
		List<MultipartFile> mfiles = m_file.getFiles("m_file");

		List<ImageVO> images = new ArrayList<ImageVO>();
		if (images.size() > -1) {
			for (MultipartFile file : mfiles) {
				String imgOriginName = file.getOriginalFilename();
				String fileUUName = imgService.fileUp(file);

				ImageVO imgVO = ImageVO.builder().img_cncode(bd_code).img_origin(imgOriginName).img_upname(fileUUName)
						.build();
				images.add(imgVO);

			}
			imgDao.insertOrUpdateList(images);
		}
	}

	@Override
	public int delete(String bd_code) {
		// TODO Auto-generated method stub

		return bdDao.delete(bd_code);
	}

	@Override
	public BoardViewDTO selectView(String bd_code) {
		// TODO Auto-generated method stub
		BoardViewDTO view = bdDao.selectBoardView(bd_code);
		return view;
	}

	@Override
	public int viewCount(String bd_code) {
		// TODO Auto-generated method stub

		return bdDao.viewCount(bd_code);
	}

	@Override
	public void update(String bd_code, BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		// TODO Auto-generated method stub
		bdDao.update(boardVO);
		bd_code = boardVO.getBd_code();
		List<ImageVO> images = new ArrayList<ImageVO>();
		List<MultipartFile> mfiles = m_file.getFiles("m_file");
		if (images.size() > -1) {
			for (MultipartFile file : mfiles) {
				String imgOriginName = file.getOriginalFilename();
				String fileUUName = imgService.fileUp(file);

				ImageVO imgVO = ImageVO.builder().img_cncode(bd_code).img_origin(imgOriginName).img_upname(fileUUName)
						.build();
				images.add(imgVO);
			}
			imgDao.insertOrUpdateList(images);
		}
	}

	@Override
	public int fileDelete(Long img_code) {
		// TODO Auto-generated method stub
		ImageVO imgVO = imgDao.findById(img_code);

		int ret = imgService.delete(imgVO.getImg_upname());

		if (ret > 0) {
			ret = imgDao.delete(img_code);
		}

		return ret;
	}

}
