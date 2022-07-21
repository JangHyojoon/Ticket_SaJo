package com.multi.cust;



import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class InsertTest {
	@Autowired
	CustBiz biz;
	@Test
	void contextLoads() {
		Date date = new Date();
		CustVO v = new CustVO("jsy","3333","정세연",date,500,"woman");
		try {
			biz.register(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
