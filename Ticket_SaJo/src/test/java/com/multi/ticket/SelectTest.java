package com.multi.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TicketBiz;
import com.multi.vo.TicketVO;

@SpringBootTest
class SelectTest {
	@Autowired
	TicketBiz biz;
	@Test
	void contextLoads() {
		TicketVO v = null;
		try {
			v = biz.get(4005);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
