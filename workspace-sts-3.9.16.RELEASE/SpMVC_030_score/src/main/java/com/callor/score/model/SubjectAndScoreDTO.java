package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectAndScoreDTO {
	
	private String ss_code;
	private String ss_stname;// as ss_name, 
	private String ss_prof;// as ss_prof,
	private String ss_stnum;// as ss_stnum,
	private int ss_score;// as ss_score

}
