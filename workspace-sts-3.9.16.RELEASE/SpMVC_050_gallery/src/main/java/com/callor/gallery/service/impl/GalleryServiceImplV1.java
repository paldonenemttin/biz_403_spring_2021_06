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
	 * @Autowired가 설정된 변수, method, 객체등을 만나면
	 * 스프링 프레임워크는 변수를 초기화 method를 실행하여 또 변수 초기화
	 * 이미 생성되어 준비된 객체에 주입등을 수행한다
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
		
		// 대표이미지가 업로드 되면
		// 이미지를 서버에 저장하고 저장된 파일의 이름을 return 받기
		String strUUID =fService.fileUp(one_file);
		
		// DTO에 이미지 이름 저장하기
		gaDTO.setG_image(strUUID);
		
		log.debug("insert 전 seq :{}", gaDTO.getG_seq());
		//GalleryDTO에 담긴 데이터를 tbl_gallery에 insert하기
		
		//mapper에서 insert를 수행한 후 새로 생성된 g_seq값을
		// select Key 하여 gaDTO의 g_seq 변수에 담아놓은 상태이다
		gaDao.insert(gaDTO);
		
		log.debug("insert 후 seq :{}", gaDTO.getG_seq());
		
		// 갤러리 게시판 seq값과 파일들을 묶음으로 insert하기 위한 준비 하기
		Long g_seq = gaDTO.getG_seq();
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		// 업로드되 ㄴ멀티파일을 서버에 업로드하고
		// 원래 파일이름과 UUID가 첨가된  파일이름을 추출하여
		// FileDTO에 담고 다시 List에 담아 놓는다
		List<MultipartFile> mfiles = m_file.getFiles("m_file");
		for(MultipartFile file : mfiles) {
			
			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);
			
			FileDTO fDto = FileDTO.builder().file_gseq(g_seq).file_origin(fileOriginName).file_upname(fileUUName).build();
			files.add(fDto);
		}
		
		log.debug("이미지들 :{} ", mfiles.toString());
		
		fDao.insertOrUpdateWithList(files);
		
	}

	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<GalleryDTO> gaList = gaDao.selectAll();
		log.debug("갤러리 리스트 :{}",gaList.toString());
		return gaList;
	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) {
		// TODO Auto-generated method stub
		
		List<GalleryFilesDTO> fgList = gaDao.findByIdGalleryFiles(g_seq);
		/*
		 * dao로 부터 select를 한 후 데이터 검증 하기 ㅜ이해 사용하는 코드
		 * gfList가 데이터가 조회되지 않아 null이 발생 할 수 있다
		 */
		if(fgList != null && fgList.size() > 0) {
		log.debug(fgList.toString());
		}else {
			log.debug("데이터 없음");
		}
		return fgList;
		
	}

	@Override
	public GalleryDTO findByIdGallery(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long g_seq) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	
	

}
