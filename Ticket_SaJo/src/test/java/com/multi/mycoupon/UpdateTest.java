package com.multi.mycoupon;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.MycouponBiz;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads()  {
	Date date = new Date();
	//int id, String uid, String cid, boolean used, Date udate
		MycouponVO v = new MycouponVO(7007,"awy",8001,false,date,date);
		// 내 쿠폰함의 쿠폰 업데이트는 사용했을 경우밖에없음 
		try {
			biz.modify(v);
			System.out.println("Update success... ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
