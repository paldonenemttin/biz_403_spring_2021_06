package com.team.starbucks.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.starbucks.dao.GenericDao;
import com.team.starbucks.model.ImageVO;

public interface ImageDao extends GenericDao<ImageVO, Long> {
	
	public int insertOrUpdateList(@Param("imgList") List<ImageVO> imgList);

}
