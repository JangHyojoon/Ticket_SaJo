package com.multi.vo;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Msg {
	private List<BookedVO> blist;
	
	private String sendid;
	private String receiveid;
	private String content1;
	private String content2;
	public Msg(List<BookedVO> blist) {
		this.blist = blist;
	}
	
}