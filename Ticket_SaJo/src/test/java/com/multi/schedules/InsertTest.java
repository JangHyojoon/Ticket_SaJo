package com.multi.schedules;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@SpringBootTest
class InsertTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads() {
		Date today = new Date();
		SchedulesVO v = new SchedulesVO(2,1000,today);
		try {
			biz.register(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
