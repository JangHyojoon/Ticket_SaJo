package com.multi.vo;

import java.util.Date;

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

public class ReviewVO {
	private int id;
	private String uid;
	private int mid;
	private int star;
	private String text;
	private Date regdate;
	
	// 7.15 김민식 추가
	private int dday;
	private String name;
	// 7.17
	private int age;
	private int rcnt;
	private String sex;
	private Double rpercent;
	
	public ReviewVO(int id, String uid, int mid, int star, String text, Date regdate) {
		this.id = id;
		this.uid = uid;
		this.mid = mid;
		this.star = star;
		this.text = text;
		this.regdate = regdate;
	}
	public ReviewVO(int id, String uid, int mid, int star, String text) {
		this.id = id;
		this.uid = uid;
		this.mid = mid;
		this.star = star;
		this.text = text;
	}
	
	
}
