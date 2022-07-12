package com.multi.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TicketBiz;
import com.multi.vo.TicketVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	TicketBiz biz;
	@Test
	void contextLoads() {
		TicketVO v = new TicketVO(4005,2000,6000,2,"A17");
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
