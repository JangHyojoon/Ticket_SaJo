package com.multi.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.MycouponMapper;
import com.multi.vo.MycouponVO;

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
	
	public List<MycouponVO> selectKeepCoupon(Map<String,Object> map) throws Exception {
		return dao.selectKeepCoupon(map);
	}

	
}
