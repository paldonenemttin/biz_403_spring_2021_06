package com.team.starbucks.model;

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

	public Long img_code;
	public String img_cncode;
	public String img_upname;
	public String img_origin;
	
}
