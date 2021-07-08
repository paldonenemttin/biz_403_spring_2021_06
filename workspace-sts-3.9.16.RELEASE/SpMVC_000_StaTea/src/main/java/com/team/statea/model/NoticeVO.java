package com.team.statea.model;

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
public class NoticeVO {
	
	private Long nt_code;
	private String nt_title;
	private String nt_content;
	private String nt_time;
	private String nt_user;

}
