package com.multi.mycoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MycouponBiz;
import com.multi.vo.MycouponVO;

@SpringBootTest
class SelectCntTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads() {
		MycouponVO v = null;
		try {
			v = biz.selectcnt("kms");
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
