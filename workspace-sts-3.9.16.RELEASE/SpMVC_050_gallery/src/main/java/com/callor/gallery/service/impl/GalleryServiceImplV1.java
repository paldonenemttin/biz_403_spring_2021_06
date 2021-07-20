package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.PageDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;
import com.callor.gallery.service.PageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * fainlë¡? ?„ ?–¸?œ inject ë³??ˆ˜?˜ ì´ˆê¸°?™”ë¥? ?•˜?Š”?° ?•„?š”?•œ
 * ?ƒ?„±?ë¥? ??™?œ¼ë¡? ë§Œë“¤?–´ì£¼ëŠ” lombok?˜ ê¸°ëŠ¥?´?‹¤
 * 
 * ?´?˜?Š¤ë¥? ?ƒ?†?•˜ë©? @RequiredArgsConstructor?Š” ?ƒ?† ë°›ì? ?´?˜?Š¤?—?„œ ?‚¬?š© ë¶ˆê? 
 */
@RequiredArgsConstructor
@Slf4j
@Service("galleryServiceV1")
public class GalleryServiceImplV1 implements GalleryService {
	protected final GalleryDao gaDao;
	protected final FileDao fDao;

	@Qualifier("fileServiceV2")
	protected final FileService fService;

	protected final PageService pService;

	/*
	 * @Autowiredê°? ?„¤? •?œ ë³??ˆ˜, method, ê°ì²´ ?“±?„ ë§Œë‚˜ë©?
	 * Spring framework?Š” ë³??ˆ˜ë¥? ì´ˆê¸°?™”, 
	 * 		methodë¥? ?‹¤?–‰?•˜?—¬ ?˜ ë³??ˆ˜ ì´ˆê¸°?™”
	 * 		?´ë¯? ?ƒ?„±?˜?–´ ì¤?ë¹„ëœ ê°ì²´?— ì£¼ì…?“±?„ ?ˆ˜?–‰?•œ?‹¤
	 */
	@Autowired
	public void create_table(GalleryDao gDao) {
		Map<String, String> maps = new HashMap<String, String>();
		gaDao.create_table(maps);
		fDao.create_table(maps);
	}

	@Override
	public int insert(GalleryDTO galleryDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws Exception {
		// TODO Auto-generated method stub

		// ???‘œ?´ë¯¸ì?ê°? ?—…ë¡œë“œ ?˜ë©?...
		// ?´ë¯¸ì?ë¥? ?„œë²„ì— ???¥?•˜ê³?
		// ???¥?œ ?ŒŒ?¼?˜ ?´ë¦„ì„ return ë°›ê¸°
		String strUUID = fService.fileUp(one_file);

		// DTO?— ?´ë¯¸ì? ?´ë¦„ì„ ???¥?•˜ê¸?
		gaDTO.setG_image(strUUID);

		log.debug(" INSERT ? „ seq {}", gaDTO.getG_seq());

		// GalleryDTO?— ?‹´ê¸? ?°?´?„°ë¥? tbl_gallery table?— insert ?•˜ê¸?
		// mapper?—?„œ insertë¥? ?ˆ˜?–‰?•œ ?›„ ?ƒˆë¡? ?ƒ?„±?œ g_seqê°’ì„
		//		selectKey ?•˜?—¬ gaDTO?˜ g_seq ë³??ˆ˜?— ?‹´?•„?†“?? ?ƒ?ƒœ?´?‹¤
		gaDao.insert(gaDTO);

		log.debug(" INSERT ?›„ seq {}", gaDTO.getG_seq());

		// ê°¤ëŸ¬ë¦? ê°œì‹œ?Œseq ê°’ê³¼ ?ŒŒ?¼?“¤?„ ë¬¶ìŒ?œ¼ë¡? insert ?•˜ê¸? ?œ„?•œ
		// ì¤?ë¹„í•˜ê¸?
		Long g_seq = gaDTO.getG_seq();

		List<FileDTO> files = new ArrayList<FileDTO>();

		// ?—…ë¡œë“œ?œ ë©??‹°?ŒŒ?¼?„ ?„œë²„ì— ?—…ë¡œë“œ ?•˜ê³?
		// ?›?˜ ?ŒŒ?¼?´ë¦„ê³¼ UUID ê°? ì²¨ê??œ ?ŒŒ?¼?´ë¦„ì„ ì¶”ì¶œ?•˜?—¬
		// FileDTO?— ?‹´ê³?
		// ?‹¤?‹œ List?— ?‹´?•„ ?†“?Š”?‹¤

		List<MultipartFile> mFiles = m_file.getFiles("m_file");
		for (MultipartFile file : mFiles) {

			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);

			FileDTO fDto = FileDTO.builder().file_gseq(g_seq) // ê°¤ëŸ¬ë¦? ?°?´?„°?˜ PKê°?
					.file_origin(fileOriginName).file_upname(fileUUName).build();
			files.add(fDto);
		}
		log.debug("?´ë¯¸ì? ?“¤ {}", files.toString());

		fDao.insertOrUpdateWithList(files);

	}

	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub

		List<GalleryDTO> gaList = gaDao.selectAll();
		log.debug("ê°¤ëŸ¬ë¦? ë¦¬ìŠ¤?Š¸ {}", gaList.toString());
		return gaList;

	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) {

		List<GalleryFilesDTO> gfList = gaDao.findByIdGalleryFiles(g_seq);

		/*
		 * daoë¡? ë¶??„° selectë¥? ?•œ ?›„ ?°?´?„° ê²?ì¦? ?•˜ê¸? ?œ„?•´ ?‚¬?š©?•˜?Š” ì½”ë“œ
		 * gfListê°? ?°?´?„°ê°? ì¡°íšŒ?˜ì§? ?•Š?•„ null?´ ë°œìƒ?• ?ˆ˜ ?ˆ?‹¤
		 */
		if (gfList != null && gfList.size() > 0) {
			log.debug(gfList.toString());
		} else {
			log.debug("ì¡°íšŒ?œ ?°?´?„°ê°? ?—†?Œ");
		}

		return gfList;
	}

	@Override
	public GalleryDTO findByIdGellery(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long g_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int file_delete(Long g_seq) {
		// TODO Auto-generated method stub

		// ?ŒŒ?¼?„ ?‚­? œ?•˜ê¸? ?œ„?•˜?—¬ ???¥?œ ?ŒŒ?¼ ? •ë³´ë?? SELECT ?•˜ê¸?
		FileDTO fDTO = fDao.findById(g_seq);

		// ?—…ë¡œë“œ?˜?–´ ???¥?œ ?ŒŒ?¼?„ ?‚­? œ
		int ret = fService.delete(fDTO.getFile_upname());

		if (ret > 0) {
			// tbl_files table?—?„œ ?°?´?„°ë¥? ?‚­? œ?•˜ê¸?
			ret = fDao.delete(g_seq);
		}
		return ret;
	}

	/*
	 * pageNumë¥? ë§¤ê°œë³??ˆ˜ë¡? ë°›ì•„?„œ
	 * selectALl ?•œ ?°?´?„°ë¥? ?˜?¼?‚´ê³?
	 * pageNum?— ?•´?‹¹?•˜?Š” list ë¶?ë¶„ë§Œ return ?•˜ê¸?
	 * 
	 * ?•œ?˜?´ì§??— ë³´ì—¬ì¤? list = 10 ê°?
	 * 
	 */
	@Override
	public List<GalleryDTO> selectAllPage(int pageNum) throws Exception {

		// 1 ? „ì²? ?°?´?„° SELECT ?•˜ê¸?
		List<GalleryDTO> gaListAll = gaDao.selectAll();

		// 2 pageNumê°? 1?´?¼ë©? list?—?„œ 0ë²ˆì§¸ ?š”?†Œ ~ 9ë²ˆì§¸ ?š”?†Œê¹Œì? ì¶”ì¶œ?•˜ê¸?
		//   pageNumê°? 2?¼ë©? list?—?„œ 10ë²ˆì§¸ ?š”?†Œ ~ 19ë²ˆì§¸ ?š”?†Œê¹Œì? ì¶”ì¶œ?•˜ê¸?
		//   pageNumê°? 3?¼ë©? list?—?„œ 20ë²ˆì§¸ ?š”?†Œ ~ 29ë²ˆì§¸ ?š”?†Œê¹Œì? ì¶”ì¶œ?•˜ê¸?

		int totalCount = gaListAll.size();

		int start = (pageNum - 1) * 10;
		int end = pageNum * 10;
		if (pageNum > totalCount * 10) {
			end = totalCount;
			start = end - 10;
		}
		List<GalleryDTO> pageList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			pageList.add(gaListAll.get(i));
		}
		return pageList;
	}

	@Override
	public List<GalleryDTO> fineBySearchOrderPage(int pageNum, String search, String column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GalleryDTO findByIdGallery(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GalleryDTO> selectAllPage(int intPageNum, Model model) throws Exception {
		// TODO Auto-generated method stub

		List<GalleryDTO> galleryAll = gaDao.selectAll();
		int totalListSize = galleryAll.size();
		
		PageDTO pageDTO = pService.makePageation(totalListSize, intPageNum);
		
		List<GalleryDTO> pageList = new ArrayList<>();
		
		for(int i = pageDTO.getOffset() ; i < pageDTO.getLimit(); i++) {
			pageList.add(galleryAll.get(i));
		}

		model.addAttribute("PAGE_NAV",pageDTO);
		model.addAttribute("GALLERYS",pageList);
		return null;
	}

	@Override
	public List<GalleryDTO> findBySearchPage(int intPageNum, String search_column, int pageNum, Model model,
			String search_text) {
		// TODO Auto-generated method stub

		List<GalleryDTO> galleryList = gaDao.findBySearch(search_text, search_column);

		int totalListSize = galleryList.size();
		PageDTO pageDTO = pService.makePageation(totalListSize, pageNum);
		
		List<GalleryDTO> pageList = new ArrayList<>();
		if(pageDTO == null) {
			
		}
		for(int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i ++) {
			pageList.add(galleryList.get(i));
		}
		model.addAttribute("GALLERYS", galleryList);
		return null;
	}

}