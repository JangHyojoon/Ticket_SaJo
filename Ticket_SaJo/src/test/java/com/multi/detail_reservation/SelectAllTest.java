package com.multi.detail_reservation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Detail_reservationBiz;
import com.multi.vo.Detail_reservationVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	Detail_reservationBiz biz;
	@Test
	void contextLoads() {
		List<Detail_reservationVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (Detail_reservationVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
