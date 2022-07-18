package com.multi.theater;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.TheaterBiz;
import com.multi.vo.TheaterVO;

@SpringBootTest
class SelectColumnsTest {
	@Autowired
	TheaterBiz biz;
	@Test
	void contextLoads() {
		List<TheaterVO> list = null;
		try {
			list= biz.selectcolumns(1);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (TheaterVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
