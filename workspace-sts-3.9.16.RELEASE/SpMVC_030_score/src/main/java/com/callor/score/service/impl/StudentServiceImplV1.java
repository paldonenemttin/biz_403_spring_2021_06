package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ScoreDao;
import com.callor.score.dao.StudentDao;
import com.callor.score.dao.SubjectDao;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("studentV1")
public class StudentServiceImplV1 implements StudentService{
	
	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final SubjectDao sbDao;
	
	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();
		
		log.debug("Service {}" , stList.toString());
		log.debug("Service {}" , scList.toString());
		log.debug("Service {}" , sbList.toString());
		return stList;
	}

}
