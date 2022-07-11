package com.multi.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.GenreBiz;
import com.multi.vo.GenreVO;

@SpringBootTest
class SelectTest {
	@Autowired
	GenreBiz biz;
	@Test
	void contextLoads() {
		GenreVO v = null;
		try {
			v = biz.get(50);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
