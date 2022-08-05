package com.multi.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class SelectAllTest {
	@Autowired
	AdminBiz biz;
	@Test
	void contextLoads() {
		List<AdminVO> list = null;
		try {
			list= biz.get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (AdminVO uv : list) {
			System.out.println(uv);
		}
	}

	

}
