package com.multi.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.GenreBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	GenreBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(50);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

}
