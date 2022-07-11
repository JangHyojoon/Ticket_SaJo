package com.multi.schedules;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	SchedulesBiz biz;
	@Test
	void contextLoads() {
		List<SchedulesVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (SchedulesVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
