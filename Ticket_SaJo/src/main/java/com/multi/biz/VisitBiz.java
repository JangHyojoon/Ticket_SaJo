package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.VisitMapper;
import com.multi.vo.VisitVO;

@Service("visitbiz")
public class VisitBiz implements Biz<String,VisitVO> {

	@Autowired
	VisitMapper dao;
	
	@Override
	public void register(VisitVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(VisitVO v) throws Exception {
		dao.update(v);
	}
	
	// 0810 안원영 추가 - 방문자수 증가 
	public void updateCount(String id) throws Exception {
		dao.updateCount(id);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public VisitVO get(String k) throws Exception {
		return dao.select(k);
	}
	
	// 0810 안원영 추가 - 하루의 방문자수 모두 더하기 
	public int SumCount() throws Exception {
		return dao.SumCount();
	}

	@Override
	public List<VisitVO> get() throws Exception {
		return dao.selectall();
	}

}