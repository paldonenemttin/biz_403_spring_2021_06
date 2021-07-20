package com.team.starbucks.model.dto;

import java.util.List;

import com.team.starbucks.model.ImageVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardViewDTO {
	
	private String bd_code;
	private String bd_title;
	private String bd_user;
	private String bd_content;
	private String bd_time;
	private String bd_date;
	private int bd_vcount;
	
	List<ImageVO> imgList;
}
