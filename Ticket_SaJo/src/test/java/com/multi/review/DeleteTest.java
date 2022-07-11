package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReviewBiz;

@SpringBootTest
class DeleteTest {
	
	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		
		try {
			biz.remove(6002);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}