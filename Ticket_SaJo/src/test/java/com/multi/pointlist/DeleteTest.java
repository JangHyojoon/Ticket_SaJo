package com.multi.pointlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PointlistBiz;

@SpringBootTest
class DeleteTest {
	
	@Autowired
	PointlistBiz biz;
	
	@Test
	void contextLoads() {
		
		try {
			biz.remove(3004);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}