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
public class NoticeViewDTO {
	
	private String nt_code;
	private String nt_title;
	private String nt_content;
	private int nt_vcount;
	private String nt_user;
	private String nt_time;
	private String nt_src;
	
}
