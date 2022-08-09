package com.multi.ticket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TicketBiz;
import com.multi.vo.TicketVO;

@SpringBootTest
class SelectSidTest {
	@Autowired
	TicketBiz biz;
	@Test
	void contextLoads() {
		List<TicketVO> v = null;
		try {
			v = biz.selectsid(2000);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
