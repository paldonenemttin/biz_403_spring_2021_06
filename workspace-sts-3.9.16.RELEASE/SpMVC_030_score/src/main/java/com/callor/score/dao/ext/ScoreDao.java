package com.callor.score.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	
	public List<ScoreDTO> selectViewAll();
	public List<ScoreDTO> findByStNum(String st_num);
	public List<SubjectAndScoreDTO> selectSubjectAndSocre(String st_num);
	
	/*
	 * my batis에서 sql select 결과가
	 * 숫자일 경우 resultTupe으로 wrapper class를 지정한다
	 * int : Integer, long : Long
	 * 
	 * 문자열의 경우 resultType으로 String 을 반드시 지정한다
	 * String : string
	 * 
	 * Dao method의 return type도 wrapper class type으로 지정
	 */
	public Integer scoreCount(String st_num);
	public Integer scoreSum(String st_num);
	/*
	 * mapper에서 사용할 변수가 복수일 경우
	 * 각각의 변수에 파람을 반드시 명시
	 *  다만 변수가 하나라면 변수 이름이 달라도 ok
	 */
	public Integer insertOrUpdate(@Param("sc_stnum") String sc_stnum, @Param("sc_sbcode") String sc_sbcode ,@Param("sc_socre") String sc_score);

}
