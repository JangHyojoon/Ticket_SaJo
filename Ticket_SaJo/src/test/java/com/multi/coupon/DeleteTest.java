package com.multi.coupon;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CouponBiz;


@SpringBootTest
class DeleteTest {
	@Autowired
	CouponBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove("eventTest01");
			System.out.println("Delete success ... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
