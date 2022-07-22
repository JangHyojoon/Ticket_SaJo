package com.multi.booked;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BookedBiz;
import com.multi.vo.BookedVO;

@SpringBootTest
class SelectSeatlistTest {
	@Autowired
	BookedBiz biz;
	@Test
	void contextLoads() {
		List<BookedVO> list = null;
		try {
			list= biz.selectseatlist(2000, 1);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (BookedVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
