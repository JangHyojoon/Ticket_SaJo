package com.multi.movie;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@SpringBootTest
class SerachAllTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		MovieVO v = null;
		List<MovieVO> mlist = null;
		try {
			mlist = biz.searchall("a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MovieVO movieVO : mlist) {
			System.out.println(movieVO);
		}
	}

	

}
