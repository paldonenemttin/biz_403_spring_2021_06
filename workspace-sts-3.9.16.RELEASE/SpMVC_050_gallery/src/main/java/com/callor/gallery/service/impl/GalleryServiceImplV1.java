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
 * fainl�? ?��?��?�� inject �??��?�� 초기?���? ?��?��?�� ?��?��?��
 * ?��?��?���? ?��?��?���? 만들?��주는 lombok?�� 기능?��?��
 * 
 * ?��?��?���? ?��?��?���? @RequiredArgsConstructor?�� ?��?�� 받�? ?��?��?��?��?�� ?��?�� 불�? 
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
	 * @Autowired�? ?��?��?�� �??��, method, 객체 ?��?�� 만나�?
	 * Spring framework?�� �??���? 초기?��, 
	 * 		method�? ?��?��?��?�� ?�� �??�� 초기?��
	 * 		?���? ?��?��?��?�� �?비된 객체?�� 주입?��?�� ?��?��?��?��
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

		// ???��?��미�?�? ?��로드 ?���?...
		// ?��미�?�? ?��버에 ???��?���?
		// ???��?�� ?��?��?�� ?��름을 return 받기
		String strUUID = fService.fileUp(one_file);

		// DTO?�� ?��미�? ?��름을 ???��?���?
		gaDTO.setG_image(strUUID);

		log.debug(" INSERT ?�� seq {}", gaDTO.getG_seq());

		// GalleryDTO?�� ?���? ?��?��?���? tbl_gallery table?�� insert ?���?
		// mapper?��?�� insert�? ?��?��?�� ?�� ?���? ?��?��?�� g_seq값을
		//		selectKey ?��?�� gaDTO?�� g_seq �??��?�� ?��?��?��?? ?��?��?��?��
		gaDao.insert(gaDTO);

		log.debug(" INSERT ?�� seq {}", gaDTO.getG_seq());

		// 갤러�? 개시?��seq 값과 ?��?��?��?�� 묶음?���? insert ?���? ?��?��
		// �?비하�?
		Long g_seq = gaDTO.getG_seq();

		List<FileDTO> files = new ArrayList<FileDTO>();

		// ?��로드?�� �??��?��?��?�� ?��버에 ?��로드 ?���?
		// ?��?�� ?��?��?��름과 UUID �? 첨�??�� ?��?��?��름을 추출?��?��
		// FileDTO?�� ?���?
		// ?��?�� List?�� ?��?�� ?��?��?��

		List<MultipartFile> mFiles = m_file.getFiles("m_file");
		for (MultipartFile file : mFiles) {

			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);

			FileDTO fDto = FileDTO.builder().file_gseq(g_seq) // 갤러�? ?��?��?��?�� PK�?
					.file_origin(fileOriginName).file_upname(fileUUName).build();
			files.add(fDto);
		}
		log.debug("?��미�? ?�� {}", files.toString());

		fDao.insertOrUpdateWithList(files);

	}

	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub

		List<GalleryDTO> gaList = gaDao.selectAll();
		log.debug("갤러�? 리스?�� {}", gaList.toString());
		return gaList;

	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) {

		List<GalleryFilesDTO> gfList = gaDao.findByIdGalleryFiles(g_seq);

		/*
		 * dao�? �??�� select�? ?�� ?�� ?��?��?�� �?�? ?���? ?��?�� ?��?��?��?�� 코드
		 * gfList�? ?��?��?���? 조회?���? ?��?�� null?�� 발생?��?�� ?��?��
		 */
		if (gfList != null && gfList.size() > 0) {
			log.debug(gfList.toString());
		} else {
			log.debug("조회?�� ?��?��?���? ?��?��");
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

		// ?��?��?�� ?��?��?���? ?��?��?�� ???��?�� ?��?�� ?��보�?? SELECT ?���?
		FileDTO fDTO = fDao.findById(g_seq);

		// ?��로드?��?�� ???��?�� ?��?��?�� ?��?��
		int ret = fService.delete(fDTO.getFile_upname());

		if (ret > 0) {
			// tbl_files table?��?�� ?��?��?���? ?��?��?���?
			ret = fDao.delete(g_seq);
		}
		return ret;
	}

	/*
	 * pageNum�? 매개�??���? 받아?��
	 * selectALl ?�� ?��?��?���? ?��?��?���?
	 * pageNum?�� ?��?��?��?�� list �?분만 return ?���?
	 * 
	 * ?��?��?���??�� 보여�? list = 10 �?
	 * 
	 */
	@Override
	public List<GalleryDTO> selectAllPage(int pageNum) throws Exception {

		// 1 ?���? ?��?��?�� SELECT ?���?
		List<GalleryDTO> gaListAll = gaDao.selectAll();

		// 2 pageNum�? 1?��?���? list?��?�� 0번째 ?��?�� ~ 9번째 ?��?��까�? 추출?���?
		//   pageNum�? 2?���? list?��?�� 10번째 ?��?�� ~ 19번째 ?��?��까�? 추출?���?
		//   pageNum�? 3?���? list?��?�� 20번째 ?��?�� ~ 29번째 ?��?��까�? 추출?���?

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