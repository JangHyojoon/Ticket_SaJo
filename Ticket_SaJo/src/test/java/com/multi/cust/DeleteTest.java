package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	CustBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove("id11");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
