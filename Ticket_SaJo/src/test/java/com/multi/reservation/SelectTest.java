package com.multi.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.ReservationBiz;
import com.multi.vo.CustVO;
import com.multi.vo.ReservationVO;

@SpringBootTest
class SelectTest {
	@Autowired
	ReservationBiz biz;
	@Test
	void contextLoads() {
		ReservationVO v = null;
		try {
			v = biz.get(6005);
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
