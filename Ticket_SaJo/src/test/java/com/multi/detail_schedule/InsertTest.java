package com.multi.detail_schedule;

import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;

@SpringBootTest
class InsertTest {
	@Autowired
	Detail_SchedulesBiz biz;
	@Test
	void contextLoads() {
		Time now = new Time(13,00,00);
		Detail_SchedulesVO v = new Detail_SchedulesVO(2002,1,now,now);
		try {
			biz.register(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
