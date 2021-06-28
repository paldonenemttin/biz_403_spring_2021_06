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
public class NoticeViewDTO {
	
	private String notice_code;
	private String notice_title;
	private String notice_content;
	private int notice_vcount;
	private String notice_user;
	private String notice_date;
	private String notice_time;
	private String img_src;
	
}
