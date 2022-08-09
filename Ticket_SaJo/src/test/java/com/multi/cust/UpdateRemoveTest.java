package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class UpdateRemoveTest {
	@Autowired
	CustBiz biz;
	@Test
	void contextLoads()  {
		CustVO v = new CustVO("id01", true);
		try {
			biz.updateremove("id02");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
