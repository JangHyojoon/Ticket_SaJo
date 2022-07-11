package com.multi.schedules;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads()  {
		Date today = new Date();
		SchedulesVO v = new SchedulesVO(2001,1,1000,today);
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
