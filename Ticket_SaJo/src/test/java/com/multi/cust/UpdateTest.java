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
	Date today = new Date();
		CustVO v = new CustVO("id01","pwd01","정말숙",today,2000,"women");
		try {
			biz.modify(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
