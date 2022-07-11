package com.multi.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(1005);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
