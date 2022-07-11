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
public class Detail_reservationVO {
	private int id;
	private int sid;
	private Date purchasedate;
	private int mcnt;
	private String seatid;
	public Detail_reservationVO(int sid, int mcnt, String seatid) {
		this.sid = sid;
		this.mcnt = mcnt;
		this.seatid = seatid;
	}
	public Detail_reservationVO(int id, int sid, int mcnt, String seatid) {
		this.id = id;
		this.sid = sid;
		this.mcnt = mcnt;
		this.seatid = seatid;
	}
	
	
}
