package com.callor.score.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.dao.ext.StudentDao;
import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("studentV1")
public class StudentServiceImplV1 implements StudentService {

	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final SubjectDao sbDao;

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();

		log.debug("Service {}", stList.toString());
		log.debug("Service {}", scList.toString());
		log.debug("Service {}", sbList.toString());
		return stList;
	}

	@Override
	public Map<String, Object> selectMaps() {
		// TODO Auto-generated method stub
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();
		List<ScoreDTO> scViewList = scDao.selectViewAll();

		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put("학생", stList);
		maps.put("점수", scList);
		maps.put("과목", sbList);
		maps.put("View", scViewList);
		return maps;
	}

	@Override
	public String makeStNum() {
		// TODO Auto-generated method stub
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		String curYear = sd.format(date);
		
		String newStNum = this.makeStNum(curYear);
		log.debug("현재년도 {}, 생성된 학번 {}",curYear,newStNum);

		return newStNum;
	}

	@Override
	public String makeStNum(String prefix) {
		// TODO Auto-generated method stub
		
		String stNum = stDao.getMaxStNum();
		
		String stSeq = stNum.substring(prefix.length());
		log.debug("학번 : {} ", stSeq);
		Integer intSeq = Integer.valueOf(stSeq) + 1;

		String newStNum = String.format("%s%04d", prefix,intSeq);
		log.debug("새로 생성된 학번 : {}",newStNum);

		return newStNum;
	}

	@Override
	public int insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		/*
		 * insert를 수행하는 시점에서 학번을 만들고 싶으면
		 * 
		 */
//		String newStNum = this.makeStNum();
//		stVO.setSt_num(newStNum);
		return stDao.insert(stVO);
	}

	@Override
	public int update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String detail(Model model, String st_num) {
		
		String ret = null;
		// TODO Auto-generated method stub
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjectAndSocre(st_num);
		StudentVO stVO = stDao.findById(st_num);
		
		ret = ssList != null ? "OK" : "SS_FAIL";
		ret = stVO != null ? "OK" : "ST_FAIL"; //상황연산자
		model.addAttribute("SSLIST", ssList);
		model.addAttribute("ST", stVO);
		return ret;
	}

	@Override
	public String scoreInput(ScoreInputVO scInputVO) {
		// TODO Auto-generated method stub
		
		log.debug("Service RCV : {}" , scInputVO.toString());
		
		int size = scInputVO.getSubject().size();
		for(int i = 0; i < size ; i++) {
			scDao.insertOrUpdate(scInputVO.getSt_num(), scInputVO.getSubject().get(i), scInputVO.getScore().get(i));
		}
		return null;
	}

}
