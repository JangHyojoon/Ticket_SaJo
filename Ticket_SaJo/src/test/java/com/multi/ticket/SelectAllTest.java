package com.multi.ticket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TicketBiz;
import com.multi.vo.TicketVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	TicketBiz biz;
	@Test
	void contextLoads() {
		List<TicketVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (TicketVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
