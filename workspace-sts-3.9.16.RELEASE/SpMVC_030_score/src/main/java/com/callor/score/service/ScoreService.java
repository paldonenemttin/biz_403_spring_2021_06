package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreService {
	
	public List<ScoreDTO> selectAll();
	public List<SubjectAndScoreDTO> selectScore(String st_num);

}
