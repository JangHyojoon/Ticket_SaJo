package com.multi.mycoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MycouponBiz;

@SpringBootTest
class UseCouponTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads()  {
	
	
		try {
			biz.usecoupon(7011);
			System.out.println("Update success... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
