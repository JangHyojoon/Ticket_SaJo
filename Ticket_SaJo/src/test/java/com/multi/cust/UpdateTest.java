package com.multi.cust;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class UpdateTest {
	@Autowired
	CustBiz biz;
	@Test
	void contextLoads()  {
	Date date = new Date();
		CustVO v = new CustVO("id04","pwd04","주말숙",date,0,"woman");
		try {
			biz.modify(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
