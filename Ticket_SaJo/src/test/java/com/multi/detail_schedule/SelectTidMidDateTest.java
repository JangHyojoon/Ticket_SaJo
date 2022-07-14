package com.multi.detail_schedule;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;

@SpringBootTest
class SelectTidMidDateTest {
	@Autowired
	Detail_SchedulesBiz biz;
	@Test
	void contextLoads() {
		List<Detail_SchedulesVO> list = null;
		try {
			list= biz.selecttidmiddate(2,1002, "20220709");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (Detail_SchedulesVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
