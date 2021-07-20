package com.callor.gallery.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;

public interface GalleryService {
	
	public int insert(GalleryDTO galleryDTO) throws Exception;

	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws Exception;

	public List<GalleryDTO> selectAll() throws Exception;

	// 조건에 관계 없이  전체리스트를 pagination을 적용한 list로 만들기
	// pageNum값을 매개변수로 받아서 일정할 분량으로 잘라
	// list를 return하기
	public List<GalleryDTO> selectAllPage(int pageNum) throws Exception;
	public List<GalleryDTO> selectAllPage(int intPageNum ,Model model) throws Exception;
	// 검색조건과 pageNum 값을 매개변수로 받아서 조건 검색을 수행한 후
	// 일정 분량으로 잘라서 list를 return
	public List<GalleryDTO> findBySearchPage(int intPageNum, String search_column,int pageNum, Model model, String search_text);
	
	// 검색소건, 정렬조건, pageNum 값 매개변수로 받아서 List return 하기
	public List<GalleryDTO> fineBySearchOrderPage(int pageNum, String search, String column);
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq);
	
	public GalleryDTO findByIdGallery(Long g_seq);

	public int delete(Long g_seq);

	public int file_delete(Long g_seq);

	GalleryDTO findByIdGellery(Long g_seq);

	
	
	

}
