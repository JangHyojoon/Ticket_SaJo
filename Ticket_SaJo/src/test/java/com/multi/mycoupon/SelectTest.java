package com.multi.mycoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.MycouponBiz;
import com.multi.biz.ReservationBiz;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;
import com.multi.vo.ReservationVO;

@SpringBootTest
class SelectTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads() {
		MycouponVO v = null;
		try {
			v = biz.get(7006);
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
