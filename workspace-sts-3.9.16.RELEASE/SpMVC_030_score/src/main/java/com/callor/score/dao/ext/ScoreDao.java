package com.callor.score.dao.ext;

import java.util.List;
import java.util.Map;

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
	 * my batis���� sql select �����
	 * ������ ��� resultTupe���� wrapper class�� �����Ѵ�
	 * int : Integer, long : Long
	 * 
	 * ���ڿ��� ��� resultType���� String �� �ݵ�� �����Ѵ�
	 * String : string
	 * 
	 * Dao method�� return type�� wrapper class type���� ����
	 */
	public Integer scoreCount(String st_num);
	public Integer scoreSum(String st_num);
	/*
	 * mapper���� ����� ������ ������ ���
	 * ������ ������ �Ķ��� �ݵ�� ���
	 *  �ٸ� ������ �ϳ���� ���� �̸��� �޶� ok
	 */
	public Integer insertOrUpdate(@Param("sc_stnum") String sc_stnum, @Param("sc_sbcode") String sc_sbcode ,@Param("sc_score") String sc_score);
	
	public Integer insertOrUpdateForList(@Param("sc_stnum") String st_num,@Param("scoreMaps") List<Map<String, String>> scoreMaps);

}
