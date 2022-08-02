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
	private String hascoupon;//0730 안원영 추가 - 쿠폰 가지고 있는지 확인 
	public CouponVO(int id, String name, Date sdate, Date edate, String icon, int sale, String text) {
		super();
		this.id = id;
		this.name = name;
		this.sdate = sdate;
		this.edate = edate;
		this.icon = icon;
		this.sale = sale;
		this.text = text;
	}


}
