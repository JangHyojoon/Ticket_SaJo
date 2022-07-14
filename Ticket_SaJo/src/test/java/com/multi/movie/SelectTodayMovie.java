package com.multi.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@SpringBootTest
class SelectTodayMovie {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		List<MovieVO> v = null;
	
		
		try {
			v = biz.todayMovieList();
			
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
