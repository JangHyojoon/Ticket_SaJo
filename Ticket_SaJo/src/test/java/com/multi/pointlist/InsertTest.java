package com.multi.pointlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PointlistBiz;
import com.multi.vo.PointlistVO;

@SpringBootTest
class InsertTest {
	
	@Autowired
	PointlistBiz biz;
	
	@Test
	void contextLoads() {
		PointlistVO pl = new PointlistVO(3005, "hms", 4000, "2021-02-04", "쿠폰5");
		try {
			biz.register(pl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}