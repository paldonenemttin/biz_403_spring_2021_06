package com.team.starbucks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardListDTO {
	
	private String bd_code;
	private String bd_title;
	private String bd_content;
	private String bd_user;
	private String bd_vcount;
	private String bd_time;

}
