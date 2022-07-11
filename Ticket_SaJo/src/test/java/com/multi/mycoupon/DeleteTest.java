package com.multi.mycoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MycouponBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(7007);
			System.out.println("Delete success ... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
