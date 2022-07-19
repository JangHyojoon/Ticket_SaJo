package com.multi.theater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;
import com.multi.vo.TheaterVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads()  {

		TheaterVO v = new TheaterVO(4,"A","01","A1");
		try {
			biz.updateone(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
