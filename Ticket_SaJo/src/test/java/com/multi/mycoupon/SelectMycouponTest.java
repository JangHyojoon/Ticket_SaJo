package com.multi.mycoupon;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MycouponBiz;
import com.multi.vo.MycouponVO;

@SpringBootTest
class SelectMycouponTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads() {
		List<MycouponVO> list = null;
		try {
			list= biz.selectmycoupon("kms");
			
			System.out.println("SELECT ALL Success ... ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (MycouponVO vo : list) {
			System.out.println(vo);
		}
	}
}
