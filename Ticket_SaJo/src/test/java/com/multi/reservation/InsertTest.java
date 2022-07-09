package com.multi.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReservationBiz;
import com.multi.vo.ReservationVO;

@SpringBootTest
class InsertTest {
	
	@Autowired
	ReservationBiz biz;
	
	@Test
	void contextLoads() {
		
		ReservationVO v = new ReservationVO(4001,"kms",1,10000,9000);
		try {
			biz.register(v);
			System.out.println("insert ok... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
