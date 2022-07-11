package com.multi.detail_reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_reservationBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	Detail_reservationBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(4006);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

}
