package com.team.statea.model;

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
	
	private String board_code;
	private String board_content;
	private String board_user;
	private int like_count;
	private String board_vcount;
	private String board_date;
	private String board_time;

}
