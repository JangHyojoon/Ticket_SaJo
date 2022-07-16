package com.multi.schedules;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@SpringBootTest
class SelectMovieonSchedulesTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads() {
		List<SchedulesVO> list = null;
		try {
			list= biz.selectmovieonschedules();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (SchedulesVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
