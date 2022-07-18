package com.multi.theater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;
import com.multi.vo.TheaterVO;

@SpringBootTest
class SelectSeatidTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads() {
		TheaterVO v = null;
		try {
			v = biz.selectseatid(1,1,1);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
