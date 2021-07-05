package com.team.statea.model.dto;

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
	private String bd_writer;
	private String bd_content;
	private int like_count;
	private String bd_img;
	private String bd_time;
	private int bd_vcount;

}
