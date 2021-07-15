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

	// ���ǿ� ���� ����  ��ü����Ʈ�� pagination�� ������ list�� �����
	// pageNum���� �Ű������� �޾Ƽ� ������ �з����� �߶�
	// list�� return�ϱ�
	public List<GalleryDTO> selectAllPage(int pageNum) throws Exception;
	public List<GalleryDTO> selectAllPage(int intPageNum ,Model model) throws Exception;
	// �˻����ǰ� pageNum ���� �Ű������� �޾Ƽ� ���� �˻��� ������ ��
	// ���� �з����� �߶� list�� return
	public List<GalleryDTO> findBySearchPage(int intPageNum, String search_column,int pageNum, Model model, String search_text);
	
	// �˻��Ұ�, ��������, pageNum �� �Ű������� �޾Ƽ� List return �ϱ�
	public List<GalleryDTO> fineBySearchOrderPage(int pageNum, String search, String column);
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq);
	
	public GalleryDTO findByIdGallery(Long g_seq);

	public int delete(Long g_seq);

	public int file_delete(Long g_seq);

	GalleryDTO findByIdGellery(Long g_seq);

	
	
	

}
