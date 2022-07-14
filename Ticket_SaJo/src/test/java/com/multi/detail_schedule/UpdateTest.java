package com.multi.detail_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	Detail_SchedulesBiz biz;
	@Test
	void contextLoads()  {
	
		Detail_SchedulesVO v = new Detail_SchedulesVO(2005,1,"210000","240000");
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
