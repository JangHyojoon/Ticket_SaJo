package com.multi.movie;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		List<MovieVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (MovieVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
