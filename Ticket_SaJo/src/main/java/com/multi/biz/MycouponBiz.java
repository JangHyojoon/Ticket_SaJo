package com.multi.biz;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.MycouponMapper;
import com.multi.mapper.ReservationMapper;
import com.multi.vo.MycouponVO;
import com.multi.vo.ReservationVO;

@Service("mycouponbiz")
public class MycouponBiz implements Biz<Integer,MycouponVO> {

	@Autowired
	MycouponMapper dao;
	
	@Override
	public void register(MycouponVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(MycouponVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public MycouponVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<MycouponVO> get() throws Exception {
		return dao.selectall();
	}

	
}
