package com.multi.vo;

import java.sql.Time;
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
public class Detail_SchedulesVO {
	private int sid;
	private int mcnt;
	private Time starttime;
	private Time endtime;
	
	private int tid;
	private int mid;
	private Date sdate;
	
	
	public Detail_SchedulesVO(int sid, int mcnt, Time starttime, Time endtime) {
		super();
		this.sid = sid;
		this.mcnt = mcnt;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	
	


}
