package com.multi.pointlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PointlistBiz;
import com.multi.vo.PointlistVO;

@SpringBootTest
class SelectPriceTest {
	
	@Autowired
	PointlistBiz biz;
	
	@Test
	void contextLoads() {
		PointlistVO pl = null;
		try {
			pl = biz.selectprice("kms");
			System.out.println(pl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}