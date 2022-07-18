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
	private String seatid;
	private String r;
	private int c;
	
	private int rcnt;
	private int ccnt;
	
	
	public TheaterVO(int id, String seatid, String r, int c) {
		super();
		this.id = id;
		this.seatid = seatid;
		this.r = r;
		this.c = c;
	}


	public TheaterVO(int id, int rcnt, int ccnt) {
		super();
		this.id = id;
		this.rcnt = rcnt;
		this.ccnt = ccnt;
	}
	
	
}
