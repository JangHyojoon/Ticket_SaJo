package com.multi.detail_reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_reservationBiz;
import com.multi.vo.Detail_reservationVO;

@SpringBootTest
class SelectTest {
	@Autowired
	Detail_reservationBiz biz;
	@Test
	void contextLoads() {
		Detail_reservationVO v = null;
		try {
			v = biz.get(4005);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
