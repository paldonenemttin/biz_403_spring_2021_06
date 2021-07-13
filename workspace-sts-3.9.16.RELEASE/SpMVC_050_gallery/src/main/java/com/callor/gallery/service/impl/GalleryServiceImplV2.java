package com.callor.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("galleryServiceV2")
public class GalleryServiceImplV2 extends GalleryServiceImplV1{

	/*
	 * @RequiredArgsConstructor ������ ��ӹ��� Ŭ��������
	 * ������ ������ ������ ��
	 * 
	 */
	public GalleryServiceImplV2(GalleryDao gaDao, FileDao fDao, 
			@Qualifier("fileServiceV2")
			FileService fService) {
		super(gaDao, fDao, fService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GalleryDTO findByIdGallery(Long g_seq) {
		// TODO Auto-generated method stub
		GalleryDTO gallery = gaDao.findByIdGalleryFilesResultMap(g_seq);
		if(gallery != null) {
			log.debug("������ ������ :{}", gallery.toString());
		}
		
		return gallery;
	}

	/*
	 * ÷�������� �ִ� �Խù� �����ϱ�
	 * 1. ÷������ ���� ��
	 * 		��. ÷�������� �����ϱ� ���� �����͸� �ٽ� 
	 * 			select�Ͽ� ÷������ �̸��� ��������
	 * 		��. ������ �̸����� ������ �����ϰ�
	 * 2. �Խù� �����͸� ����
	 * 
	 * ÷������ �Ӹ��ƴ϶� join�� �����Ͱ� �� �ִ�
	 * Join �����Ϳ� ÷������ ������ �� �ִ�
	 * 
	 * 1. join�� �������� ���������� ������ ��
	 * 2. join�� �����͸� �����ϰ�
	 * 3. ������ ÷�������� �����ϰ�
	 * 4. ������ ����
	 * 
	 */
	@Override
	public int delete(Long g_seq) {
		// TODO Auto-generated method stub
		
		GalleryDTO gaDTO = gaDao.findByIdGalleryFilesResultMap(g_seq);
		if(gaDTO == null) {
			return 0;
		}
		List<FileDTO> fileList = gaDTO.getFileList();
		for(FileDTO file : fileList) {
			// ÷������ ����
			String attFileName = file.getFile_upname();
			int ret = fService.delete(attFileName);
			
			// ������ �Ѱ��� ����
			if(ret > 0) {
				fDao.delete(file.getFile_seq());
			}
		}
		
		// ���� ÷������ ����
		String imgFileName = gaDTO.getG_image();
		int ret = fService.delete(imgFileName);
		if(ret > 0) {
			gaDao.delete(g_seq);
		}else {
			log.debug("������ ���� ����");
		}
		// ���� ������ ����
		//gaDao.delete(g_seq);
		return 1;
	}
	
	
	
	
	
}
