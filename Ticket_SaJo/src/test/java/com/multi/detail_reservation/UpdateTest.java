package com.multi.detail_reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_reservationBiz;
import com.multi.vo.Detail_reservationVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	Detail_reservationBiz biz;
	@Test
	void contextLoads() {
		Detail_reservationVO v = new Detail_reservationVO(4005,2000,2,"A17");
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
