package com.multi.booked;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BookedBiz;
import com.multi.vo.BookedVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	BookedBiz biz;
	@Test
	void contextLoads() {
		List<BookedVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (BookedVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
