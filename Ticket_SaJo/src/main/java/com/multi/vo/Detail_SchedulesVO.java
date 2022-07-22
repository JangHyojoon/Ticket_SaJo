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
public class Detail_SchedulesVO {
	private int sid;
	private int mcnt;
	private String starttime;
	private String endtime;
	private String booked;
	
	private int tid;

	private int mid;
	private String sdate;
	private String title;
	
	public Detail_SchedulesVO(int sid, int mcnt, String starttime, String endtime) {
		super();
		this.sid = sid;
		this.mcnt = mcnt;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public Detail_SchedulesVO(int sid, int mcnt, String starttime, String endtime, String booked) {
		super();
		this.sid = sid;
		this.mcnt = mcnt;
		this.starttime = starttime;
		this.endtime = endtime;
		this.booked = booked;
	}

	
	
	
	

	
	


}
