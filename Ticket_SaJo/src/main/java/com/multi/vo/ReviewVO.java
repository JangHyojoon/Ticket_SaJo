package com.multi.vo;

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
	private String regdate;
}
