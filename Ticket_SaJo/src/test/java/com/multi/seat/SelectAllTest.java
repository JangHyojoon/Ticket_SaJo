package com.multi.seat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SeatBiz;
import com.multi.vo.SeatVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	SeatBiz biz;
	@Test
	void contextLoads() {
		List<SeatVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (SeatVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
