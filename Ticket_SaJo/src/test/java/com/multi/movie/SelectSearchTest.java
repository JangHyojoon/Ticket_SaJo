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
class SelectSearchTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		List<MovieVO> v = null;
		Map<String , String> map = new HashMap<String, String>();
		
//		map.put("searchfield","category");
//		map.put("searchtxt","로맨스");
		
		map.put("searchfield","actors");
		map.put("searchtxt","victor");
		
		
		try {
			v = biz.search(map);
			
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
