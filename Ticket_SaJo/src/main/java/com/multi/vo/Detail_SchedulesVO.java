package com.multi.vo;

import java.sql.Time;

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
	
	


}
