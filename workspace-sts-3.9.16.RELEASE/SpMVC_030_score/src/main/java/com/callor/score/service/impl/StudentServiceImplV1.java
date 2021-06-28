package com.callor.score.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
		List<ScoreDTO> scViewList = scDao.selectViewAll();
		
		log.debug("Service {}", stList.toString());
		log.debug("Service {}", scList.toString());
		log.debug("Service {}", sbList.toString());
		log.debug("Service Scire View {} ", scViewList.toString());
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

	/*
	 * transaction의 조건
	 * 다수의 crud는 한개의 업무 프로세스다
	 * 다수의 crud가 모두 정상적으로 완료되어야지만
	 * 업무가 정상으로 수행된다
	 * 
	 * 업무가 수행되는 동안 한곳이라도 crud에서 오류가 발생하면
	 * 그중 cud가 진행되는 동안 문제가 발생하고
	 * 데이터에 오류가 저장될 것이다
	 * 
	 * 이런 상황ㅇㄹ 방지하기 위해
	 * 업무단위를 transaction이란느 단위로 묶고
	 * 모든업무가 완료되면 data를 commit하고
	 * 그렇지 않으면 rollback all 하는 처리
	 */
	@Transactional
	@Override
	public String scoreInput(ScoreInputVO scInputVO) {
		// TODO Auto-generated method stub
		
		log.debug("Service RCV : {}" , scInputVO.toString());
		
		int size = scInputVO.getSubject().size();
		String st_num = scInputVO.getSt_num();
		
		// 학생별 과목별 성적을 과목별로 개별 Insert수행
//		for(int i = 0; i < size ; i++) {
//			scDao.insertOrUpdate(scInputVO.getSt_num(), 
//					scInputVO.getSubject().get(i), 
//					scInputVO.getScore().get(i));
//		}
		
		// Dao에 보낼 데이터를 변경하기
		
		// 과목 코드와 점수의 list를 담을 변수 선언
		List<Map<String, String>> ScoreMaps = new ArrayList<Map<String,String>>();
		for(int i = 0; i < size; i++) {
			String subject = scInputVO.getSubject().get(i);
			String score =  scInputVO.getScore().get(i);
			
			Map<String,String> subjectScore = new HashMap<String, String>();
			subjectScore.put("subject", subject);
			subjectScore.put("score", score);
			ScoreMaps.add(subjectScore);
		}
		scDao.insertOrUpdateForList(st_num, ScoreMaps);
		
//		throw new RuntimeException();
		return null;
	}

}
