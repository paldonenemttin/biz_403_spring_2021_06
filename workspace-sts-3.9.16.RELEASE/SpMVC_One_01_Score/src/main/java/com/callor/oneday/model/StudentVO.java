package com.callor.oneday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
	
	private String st_code;
	private String st_name;
	private String st_grade;
	private String st_spec;
	private String st_tel;
	private String st_addr;

}
