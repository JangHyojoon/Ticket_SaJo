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
public class CouponVO {
	private int id;
	private String name;
	private String sdate;
	private String edate;
	private String icon;
	private int sale;
	private String text;
}
