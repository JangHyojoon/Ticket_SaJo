package com.multi.seat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SeatBiz;
import com.multi.vo.SeatVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	SeatBiz biz;
	@Test
	void contextLoads() {
		SeatVO v = new SeatVO("T01","T",02);
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
