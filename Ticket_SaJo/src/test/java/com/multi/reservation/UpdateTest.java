package com.multi.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReservationBiz;
import com.multi.vo.ReservationVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	ReservationBiz biz;
	@Test
	void contextLoads()  {
	ReservationVO v = new ReservationVO(6005,"kms",2,20000,19000);
		try {
			biz.modify(v);
			System.out.println("update success... ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
