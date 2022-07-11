package com.multi.detail_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;

@SpringBootTest
class DeleteTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads() {
		
		try {
			biz.remove(2001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
