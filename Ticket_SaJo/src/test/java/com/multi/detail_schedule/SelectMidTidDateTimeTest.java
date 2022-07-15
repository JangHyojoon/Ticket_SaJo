package com.multi.detail_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;

@SpringBootTest
class SelectMidTidDateTimeTest {
	@Autowired
	Detail_SchedulesBiz biz;
	@Test
	void contextLoads() {
		Detail_SchedulesVO dsv = null;
		try {
			dsv= biz.selectmidtidsdatetime(1002,3,"20220709","160000");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			System.out.println(dsv);
		
	}

	

}
