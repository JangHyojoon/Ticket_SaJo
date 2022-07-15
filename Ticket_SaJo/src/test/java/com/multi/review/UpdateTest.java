package com.multi.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReviewBiz;
import com.multi.vo.ReviewVO;

@SpringBootTest
class UpdateTest {
	
	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads()  {
		ReviewVO r = new ReviewVO(6005, "jck", 1005, 1, "슬프다");
		try {
			biz.modify(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}