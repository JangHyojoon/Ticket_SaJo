package com.multi.seat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SeatBiz;
import com.multi.vo.SeatVO;

@SpringBootTest
class SelectTest {
	@Autowired
	SeatBiz biz;
	@Test
	void contextLoads() {
		SeatVO v = null;
		try {
			v = biz.get("T01");
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
