package com.multi.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VisitVO {
	private String id;
	private int count; 
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	
}
