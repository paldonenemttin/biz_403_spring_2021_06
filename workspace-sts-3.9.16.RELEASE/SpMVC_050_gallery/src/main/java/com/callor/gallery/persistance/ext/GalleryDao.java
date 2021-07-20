package com.callor.gallery.persistance.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.GenericDao;

public interface GalleryDao extends GenericDao<GalleryDTO, Long> {
	
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq);
	public GalleryDTO findByIdGalleryFilesResultMap(Long g_seq);
	public int countAll();
	public List<GalleryDTO> findBySearch(@Param("text") String search_text,@Param("column") String search_column);

}
