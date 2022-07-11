package com.multi.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.biz.ReservationBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	ReservationBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(6006);
			System.out.println("Delete success ... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
