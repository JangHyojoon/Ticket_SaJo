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
public class CouponVO {
	private int id;
	private String name;
	private Date sdate;
	private Date edate;
	private String icon;
	private int sale;
	private String text;
}
