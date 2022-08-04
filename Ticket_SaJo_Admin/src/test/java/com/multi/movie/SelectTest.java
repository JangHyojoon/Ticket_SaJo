package com.multi.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@SpringBootTest
class SelectTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		MovieVO v = null;
		try {
			v = biz.get(1000);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
