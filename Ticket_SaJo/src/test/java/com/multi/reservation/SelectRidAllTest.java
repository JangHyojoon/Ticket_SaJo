package com.multi.reservation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ReservationBiz;
import com.multi.vo.ReservationVO;

@SpringBootTest
class SelectRidAllTest {
	@Autowired
	ReservationBiz biz;
	@Test
	void contextLoads() {
		List<ReservationVO> list = null;
		try {
			list= biz.selectridall(6000);
			
			System.out.println("SELECT ALL Success ... " + list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (ReservationVO vo : list) {
			System.out.println(vo);
		}
	}
}
