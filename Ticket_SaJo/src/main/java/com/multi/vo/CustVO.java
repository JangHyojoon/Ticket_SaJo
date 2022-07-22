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

public class CustVO {
	
	private String id;
	private String pwd;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;	
	private int point;
	private String sex;

}
