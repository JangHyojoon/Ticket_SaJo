package com.multi.seat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SeatBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	SeatBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove("T01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
