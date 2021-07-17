package com.team.statea.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private String bd_code;
	private String bd_title;
	private String bd_content;
	private String bd_vcount;
	private String bd_time;
	private String bd_user;
	
	List<ImageVO> imgList;
}
