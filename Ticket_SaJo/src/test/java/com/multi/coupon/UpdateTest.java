package com.multi.coupon;

import java.util.Date;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CouponBiz;
import com.multi.vo.CouponVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	CouponBiz biz;
	@Test
	void contextLoads()  {
		Date a = new Date();
		CouponVO v = new CouponVO(8010,"event07-BIG sale",a,a,"gift", 1000,"Big Sale 쿠폰입니다. ");
		try {
			biz.modify(v);
			System.out.println("Update success... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
