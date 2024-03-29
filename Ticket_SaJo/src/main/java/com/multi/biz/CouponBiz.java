package com.multi.biz;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CouponMapper;
import com.multi.vo.CouponVO;

@Service("couponbiz")
public class CouponBiz implements Biz<Integer,CouponVO> {

	@Autowired
	CouponMapper dao;
	
	@Override
	public void register(CouponVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(CouponVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public CouponVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CouponVO> get() throws Exception {
		return dao.selectall();
	}
	
	// 0722 안원영 추가 - 쿠폰 정렬 
	public List<CouponVO> selectsortall() throws Exception {
		return dao.selectsortall();
	}

	
}
