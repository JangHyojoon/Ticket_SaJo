package com.multi.booked;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BookedBiz;
import com.multi.vo.BookedVO;

@SpringBootTest
class InsertArrTest {
	@Autowired
	BookedBiz biz;
	@Test
	void contextLoads() {
	
		BookedVO v = new BookedVO(2000,1,"A01,A02,D03,D04");
		try {
			biz.register(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
