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
public class GenreVO {
	private int id;
	private String name;
	private int tid;
	public GenreVO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
