package com.multi.genre;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.GenreBiz;
import com.multi.vo.GenreVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	GenreBiz biz;
	@Test
	void contextLoads() {
		List<GenreVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (GenreVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
