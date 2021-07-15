package com.callor.gallery.model;

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
public class FileDTO {
	private Long file_seq;
	private Long file_gseq;
	private String file_origin;
	private String file_upname;

}
