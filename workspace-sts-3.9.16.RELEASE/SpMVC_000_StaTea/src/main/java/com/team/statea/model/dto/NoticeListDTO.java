package com.team.statea.model.dto;

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
public class NoticeListDTO {
		
	private String notice_code;
	private String notice_title;
	private String notice_user;
	private String notice_vcount;
	private String notice_date;
	private String notice_time;


}
