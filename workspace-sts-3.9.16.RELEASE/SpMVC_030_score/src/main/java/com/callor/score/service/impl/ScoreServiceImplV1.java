package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("scoreV1")// Annotation은 유일한 이름이어야 함
public class ScoreServiceImplV1 implements ScoreService{
	
	protected final ScoreDao scDao;
	
	@Override
	public List<ScoreDTO> selectAll() {
		// TODO Auto-generated method stub
	
		List<ScoreDTO> scList = scDao.selectViewAll();
		log.debug("Service {}" , scList.toString());
	
		return scList;
	}

	@Override
	public List<SubjectAndScoreDTO> selectScore(String st_num) {
		// TODO Auto-generated method stub
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjectAndSocre(st_num);
		return ssList;
	}

}
