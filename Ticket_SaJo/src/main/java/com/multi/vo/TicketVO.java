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
public class TicketVO {
	private int id;
	private int sid;
	private int rid;
	private String purchasedate;
	private int mcnt;
	private String seatid;
	
	public TicketVO(int sid, int rid, String purchasedate, int mcnt, String seatid) {
		super();
		this.sid = sid;
		this.rid = rid;
		this.purchasedate = purchasedate;
		this.mcnt = mcnt;
		this.seatid = seatid;
	}
	public TicketVO(int id, int sid, int rid, int mcnt, String seatid) {
		super();
		this.id = id;
		this.sid = sid;
		this.rid = rid;
		this.mcnt = mcnt;
		this.seatid = seatid;
	}
	public TicketVO(int sid, int rid, int mcnt, String seatid) {
		super();
		this.sid = sid;
		this.rid = rid;
		this.mcnt = mcnt;
		this.seatid = seatid;
	}
	public TicketVO(String purchasedate) {
		this.purchasedate = purchasedate;
	}
}