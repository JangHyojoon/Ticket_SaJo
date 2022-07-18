package com.multi.theater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;
import com.multi.vo.TheaterVO;

@SpringBootTest
class SelectCntTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads() {
		TheaterVO list = null;
		try {
			list= biz.selectcnt(2);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			System.out.println(list);
		
	}

	

}
