package com.team.statea.model;

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
public class BoardVO {
	private String board_code;
	private String board_title;
	private String board_content;
	private String board_vcount;
	private String board_date;
	private String board_time;
}
