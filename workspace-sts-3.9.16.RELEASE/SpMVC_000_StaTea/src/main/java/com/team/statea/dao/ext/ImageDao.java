package com.team.statea.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.statea.dao.GenericDao;
import com.team.statea.model.ImageVO;

public interface ImageDao extends GenericDao<ImageVO, Long> {
	
	public int insertOrUpdateList(@Param("imgList") List<ImageVO> imgList);

}
