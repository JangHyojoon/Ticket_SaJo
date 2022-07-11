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
public class ReservationVO {
	private int id;
	private int rid;
	private String uid;
	private int pcnt;
	private int price;
	private int totalprice;
	
	// Reservation insert 시 사용 
	public ReservationVO(int rid, String uid, int pcnt, int price, int totalprice) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.pcnt = pcnt;
		this.price = price;
		this.totalprice = totalprice;
	}

	
}
