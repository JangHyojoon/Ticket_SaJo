package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class SelectTest {
	@Autowired
	AdminBiz biz;
	@Test
	void contextLoads() {
		AdminVO v = null;
		try {
			v = biz.get("id01");
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
