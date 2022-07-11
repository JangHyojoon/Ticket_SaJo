package com.multi.mycoupon;

import java.util.List;

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
class SelectAllTest {
	@Autowired
	MycouponBiz biz;
	@Test
	void contextLoads() {
		List<MycouponVO> list = null;
		try {
			list= biz.get();
			
			System.out.println("SELECT ALL Success ... ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (MycouponVO vo : list) {
			System.out.println(vo);
		}
	}

	

}
