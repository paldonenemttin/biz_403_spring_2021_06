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
public class ImageVO {

	private String img_code;
	private String img_cncode;
	private String img_upname;
	private String img_name;
	
}
