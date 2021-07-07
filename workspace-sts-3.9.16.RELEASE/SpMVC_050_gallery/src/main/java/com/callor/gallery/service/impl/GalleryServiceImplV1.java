package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("galleryServiceV1")
public class GalleryServiceImplV1 implements GalleryService{

	protected final GalleryDao gaDao;
	protected final FileDao fDao;
	
	@Qualifier("fileServiceV2")
	protected final FileService fService;
	
	/*
	 * @Autowired�� ������ ����, method, ��ü���� ������
	 * ������ �����ӿ�ũ�� ������ �ʱ�ȭ method�� �����Ͽ� �� ���� �ʱ�ȭ
	 * �̹� �����Ǿ� �غ�� ��ü�� ���Ե��� �����Ѵ�
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
		
		// ��ǥ�̹����� ���ε� �Ǹ�
		// �̹����� ������ �����ϰ� ����� ������ �̸��� return �ޱ�
		String strUUID =fService.fileUp(one_file);
		
		// DTO�� �̹��� �̸� �����ϱ�
		gaDTO.setG_image(strUUID);
		
		log.debug("insert �� seq :{}", gaDTO.getG_seq());
		//GalleryDTO�� ��� �����͸� tbl_gallery�� insert�ϱ�
		
		//mapper���� insert�� ������ �� ���� ������ g_seq����
		// select Key �Ͽ� gaDTO�� g_seq ������ ��Ƴ��� �����̴�
		gaDao.insert(gaDTO);
		
		log.debug("insert �� seq :{}", gaDTO.getG_seq());
		
		// ������ �Խ��� seq���� ���ϵ��� �������� insert�ϱ� ���� �غ� �ϱ�
		Long g_seq = gaDTO.getG_seq();
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		// ���ε�� ����Ƽ������ ������ ���ε��ϰ�
		// ���� �����̸��� UUID�� ÷����  �����̸��� �����Ͽ�
		// FileDTO�� ��� �ٽ� List�� ��� ���´�
		List<MultipartFile> mfiles = m_file.getFiles("m_file");
		for(MultipartFile file : mfiles) {
			
			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);
			
			FileDTO fDto = FileDTO.builder().file_gseq(g_seq).file_origin(fileOriginName).file_upname(fileUUName).build();
			files.add(fDto);
		}
		
		log.debug("�̹����� :{} ", mfiles.toString());
		
		fDao.insertOrUpdateWithList(files);
		
	}

	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<GalleryDTO> gaList = gaDao.selectAll();
		log.debug("������ ����Ʈ :{}",gaList.toString());
		return gaList;
	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) {
		// TODO Auto-generated method stub
		
		return gaDao.findByIdGalleryFiles(g_seq);
		
	}

	
	

}
