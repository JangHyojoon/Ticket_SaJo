package com.multi.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class ReceiptVO {// 영수증 바코드 저장 테이블 
	private String id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	private String text;
	
	
}
