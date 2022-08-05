package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class InsertTest {
	@Autowired
	AdminBiz biz;
	@Test
	void contextLoads() {
		AdminVO v = new AdminVO("id01", "pwd01");
		try {
			biz.register(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
