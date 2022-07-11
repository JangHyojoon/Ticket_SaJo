package com.multi.movie;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@SpringBootTest
class InsertTest {
	@Autowired
	MovieBiz biz;
	@Test
	void contextLoads() {
		Date d = new Date(2010-9-11);
		MovieVO v = new MovieVO(22,"2001: 스페이스 오디세이","Stanley Kubrick ","Gary Lockwood, William Sylvester",d,"2001img1.jpg","2001img2.jpg","usa","239m","인류에게 문명의 지혜를 가르쳐 준 검은 돌기둥의 정체를 밝히기 위해서 목성으로 향하는 디스커버리호 안에는 선장 보우만과 승무원 풀, 전반적인 시스템을 관장하는 인공지능 컴퓨터 할이 타고 있다.평화롭던 우주선은 할이 스스로 생각하기 시작하면서부터 위기를 맞는다. 특히나 이 영화는 60년대 작품으로 인간이 아직 달에 가기 전에 만들어진, 기념비적인 SF 우주 영화.");
		try {
			biz.register(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
