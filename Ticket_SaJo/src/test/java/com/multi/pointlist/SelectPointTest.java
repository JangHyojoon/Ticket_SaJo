package com.multi.pointlist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PointlistBiz;
import com.multi.vo.PointlistVO;

@SpringBootTest
class SelectPointTest {
	
	@Autowired
	PointlistBiz biz;
	
	@Test
	void contextLoads() {
		List<PointlistVO> list = null;
		try {
			list= biz.selectpoint("id01");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (PointlistVO pl : list) {
			System.out.println(pl);
		}
	}
}