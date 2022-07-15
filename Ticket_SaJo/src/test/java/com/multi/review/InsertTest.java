package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReviewBiz;
import com.multi.vo.ReviewVO;

@SpringBootTest
class InsertTest {
	
	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		ReviewVO r = new ReviewVO(6005, "hms", 1005, 1, "슬픔");
		try {
			biz.register(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}