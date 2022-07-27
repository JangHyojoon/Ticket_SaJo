package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class UpdateCustTest {
	@Autowired
	CustBiz biz;
	@Test
	void contextLoads()  {
		CustVO v = new CustVO("id04","pwd04","주말숙");
		try {
			biz.modifycust(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
