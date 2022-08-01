package com.multi.coupon;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CouponBiz;
import com.multi.vo.CouponVO;

@SpringBootTest
class SelectTest {
	@Autowired
	CouponBiz biz;
	@Test
	void contextLoads() {
		CouponVO v = null;
		try {
			v = biz.get(8000);
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
