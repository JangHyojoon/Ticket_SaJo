package com.multi.coupon;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CouponBiz;
import com.multi.vo.CouponVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	CouponBiz biz;
	@Test
	void contextLoads() {
		List<CouponVO> list = null;
		try {
			list= biz.get();
			
			System.out.println("SELECT ALL Success ... ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (CouponVO vo : list) {
			System.out.println(vo);
		}
	}

	

}
