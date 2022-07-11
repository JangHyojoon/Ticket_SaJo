package com.multi.theater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
