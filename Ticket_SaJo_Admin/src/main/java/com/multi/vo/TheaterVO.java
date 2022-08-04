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
public class TheaterVO {
	private int id;
	private String r;
	private String c;
	private String seatid;
	
	private int rcnt;
	private int ccnt;
	
	
	public TheaterVO(int id, String r, String c) {
		super();
		this.id = id;
		this.r = r;
		this.c = c;
	}


	public TheaterVO(int id, int rcnt, int ccnt) {
		super();
		this.id = id;
		this.rcnt = rcnt;
		this.ccnt = ccnt;
	}


	public TheaterVO(int id, String r, String c, String seatid) {
		super();
		this.id = id;
		this.r = r;
		this.c = c;
		this.seatid = seatid;
	}
	
	
}
