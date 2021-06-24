package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.dao.ext.StudentDao;
import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("scoreV1")// Annotation은 유일한 이름이어야 함
public class ScoreServiceImplV1 implements ScoreService{
	
	protected final ScoreDao scDao;
	
	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
	
		List<ScoreVO> scList = scDao.selectAll();
		log.debug("Service {}" , scList.toString());
	
		return scList;
	}

}
