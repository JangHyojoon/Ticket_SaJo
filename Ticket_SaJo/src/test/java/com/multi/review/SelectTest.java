package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReviewBiz;
import com.multi.vo.ReviewVO;

@SpringBootTest
class SelectTest {
	
	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		ReviewVO r = null;
		try {
			r = biz.get(6001);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
	}
}

	

}
