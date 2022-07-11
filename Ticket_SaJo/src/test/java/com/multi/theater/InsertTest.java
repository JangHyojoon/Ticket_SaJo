package com.multi.theater;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;
import com.multi.vo.TheaterVO;

@SpringBootTest
class InsertTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads() {
		Date today = new Date();
		TheaterVO v = new TheaterVO(4,"C01",168);
		try {
			biz.register(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
