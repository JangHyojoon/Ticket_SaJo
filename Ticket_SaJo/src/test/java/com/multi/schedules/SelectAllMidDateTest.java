package com.multi.schedules;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@SpringBootTest
class SelectAllMidDateTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads() {
		List<SchedulesVO> list = null;
		
		try {
			list= biz.selectmiddate(1000,"20220707");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (SchedulesVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
