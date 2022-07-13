package com.multi.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TicketBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	TicketBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(4005);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

}
