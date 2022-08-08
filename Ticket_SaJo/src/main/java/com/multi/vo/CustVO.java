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
	
	private int usepoint;
	
	public CustVO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	
	
	


	public CustVO(String id, String pwd, String name, Date birth, int point, String sex) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.point = point;
		this.sex = sex;
	}






	public CustVO(String id, int usepoint) {
		super();
		this.id = id;
		this.usepoint = usepoint;
	}






	public String getRole() {
		return "ROLE_USER";
	}







	
	
}
