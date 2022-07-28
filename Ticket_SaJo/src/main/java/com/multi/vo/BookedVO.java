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
public class BookedVO {
	private int sid;
	private int mcnt;
	
	private String seatid;

	public BookedVO(String seatid) {
		super();
		this.seatid = seatid;
	}


}


