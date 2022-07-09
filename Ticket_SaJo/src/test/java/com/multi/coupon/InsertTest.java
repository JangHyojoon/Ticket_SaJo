package com.multi.coupon;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CouponBiz;
import com.multi.biz.MycouponBiz;
import com.multi.vo.CouponVO;
import com.multi.vo.MycouponVO;

@SpringBootTest
class InsertTest {
	
	@Autowired
	CouponBiz biz;
	
	@Test
	void contextLoads() {
		
		CouponVO v = new CouponVO("eventTest01",2000);
		try {
			biz.register(v);
			System.out.println("insert ok... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
