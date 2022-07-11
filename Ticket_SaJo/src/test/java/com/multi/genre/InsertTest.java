package com.multi.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.GenreBiz;
import com.multi.vo.GenreVO;

@SpringBootTest
class InsertTest {
	@Autowired
	GenreBiz biz;
	@Test
	void contextLoads() {
		GenreVO v = new GenreVO(50,"코미디");
		try {
			biz.register(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
