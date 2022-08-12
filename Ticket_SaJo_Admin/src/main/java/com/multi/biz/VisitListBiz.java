package com.multi.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.VisitListMapper;
import com.multi.vo.VisitListVO;
import com.multi.vo.VisitVO;

@Service("visitListbiz")
public class VisitListBiz implements Biz<Date,VisitListVO> {

	@Autowired
	VisitListMapper dao;
	
	@Override
	public void register(VisitListVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(VisitListVO v) throws Exception {
		dao.update(v);
	}
	

	@Override
	public void remove(Date k) throws Exception {
		dao.delete(k);
	}

	@Override
	public VisitListVO get(Date k) throws Exception {
		return dao.select(k);
	}
	
	@Override
	public List<VisitListVO> get() throws Exception {
		return dao.selectall();
	}
	
	// 0812 안원영 추가 - 7일간의 방문객 정보 가져오기 
	public List<VisitListVO> VisitList7Days() throws Exception {
		return dao.VisitList7Days();
	}
	// 0812 안원영 추가 - 7일간의 방문객 합 가져오기 
	public int VisitListAvg() throws Exception {
		return dao.VisitListAvg();
	}

	
}