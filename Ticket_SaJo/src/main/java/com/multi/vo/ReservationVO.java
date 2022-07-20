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
public class ReservationVO {
	private int id;

	private String uid;
	private int pcnt;
	private int price;
	private int totalprice;
	private int rid;
	// Reservation insert 시 사용 
	public ReservationVO( String uid, int pcnt, int price, int totalprice) {
		super();
		this.uid = uid;
		this.pcnt = pcnt;
		this.price = price;
		this.totalprice = totalprice;
	}
	public ReservationVO(int id, String uid, int pcnt, int price, int totalprice) {
		super();
		this.id = id;
		this.uid = uid;
		this.pcnt = pcnt;
		this.price = price;
		this.totalprice = totalprice;
	}

	
}
