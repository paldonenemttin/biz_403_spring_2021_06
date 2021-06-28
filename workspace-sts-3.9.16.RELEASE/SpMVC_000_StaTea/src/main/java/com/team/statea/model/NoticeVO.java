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
public class NoticeVO {
	
	private Long notice_code;
	private String notice_title;
	private String notice_content;
	private String notice_date;
	private String notice_time;
	private String notice_user;

}
