package com.pking.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoUser {

	private Integer id;
	private String first;
	private String last;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date dateofbirth;
	private String placeofbirth;
}
