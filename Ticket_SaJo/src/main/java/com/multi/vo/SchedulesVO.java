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
public class SchedulesVO {
	private int id;
	private int tid;
	private int mid;
	private Date sdate;
	
	
	public SchedulesVO(int tid, int mid, Date sdate) {
		super();
		this.tid = tid;
		this.mid = mid;
		this.sdate = sdate;
	}
	
	

}
