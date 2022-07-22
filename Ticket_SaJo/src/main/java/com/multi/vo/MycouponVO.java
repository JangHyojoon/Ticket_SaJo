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
public class MycouponVO {
	private int id;
	private String uid;
	private int cid;
	private boolean used;
	private Date udate;
	private Date rdate;
	
	// mycoupon insert 시 사용
	public MycouponVO(String uid, int cid, boolean used) {
		super();
		this.uid = uid;
		this.cid = cid;
		this.used = used;
	}
	
//	// mycoupone update 시 사용 
//	public MycouponVO(int id, String uid, String cid, boolean used, Date udate, Date rdate) {
//		super();
//		this.id = id;
//		this.uid = uid;
//		this.cid = cid;
//		this.used = used;
//		this.udate = udate;
//	}
//	
	
}
