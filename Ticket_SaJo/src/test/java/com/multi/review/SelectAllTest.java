package com.multi.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReviewBiz;
import com.multi.vo.ReviewVO;

@SpringBootTest
class SelectAllTest {
	
	@Autowired
	ReviewBiz biz;
	@Test
	void contextLoads() {
		List<ReviewVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (ReviewVO r : list) {
			System.out.println(r);
		}
	}
}