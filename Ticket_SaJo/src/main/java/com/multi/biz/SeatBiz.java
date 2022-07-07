package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.SeatMapper;
import com.multi.vo.SeatVO;

@Service("seatbiz")
public class SeatBiz implements Biz<String,SeatVO> {

	@Autowired
	SeatMapper dao;
	
	@Override
	public void register(SeatVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(SeatVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String id) throws Exception {
		dao.delete(id);
	}

	@Override
	public SeatVO get(String id) throws Exception {
		return dao.select(id);
	}

	@Override
	public List<SeatVO> get() throws Exception {
		return dao.selectall();
	}

	
}
