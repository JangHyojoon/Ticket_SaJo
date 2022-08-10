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
public class PointlistVO {
	private int id;
	private String uid;
	private int price;
	private String regdate;
	private String text;
	private int totalprice;
	
	// 0720 안원영 추가 - 영수증 적립금 추가 
	public PointlistVO(String uid, int price, String text) {
		super();
		this.uid = uid;
		this.price = price;
		this.text = text;
	}

	public PointlistVO(int id, String uid, int price, String regdate, String text) {
		this.id = id;
		this.uid = uid;
		this.price = price;
		this.regdate = regdate;
		this.text = text;
	}	
	
}
