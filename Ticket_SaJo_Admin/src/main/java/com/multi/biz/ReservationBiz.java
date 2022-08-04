package com.multi.biz;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.ReservationMapper;
import com.multi.vo.ReservationVO;

@Service("reservationbiz")
public class ReservationBiz implements Biz<Integer,ReservationVO> {

	@Autowired
	ReservationMapper dao;
	
	@Override
	public void register(ReservationVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(ReservationVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public ReservationVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReservationVO> get() throws Exception {
		return dao.selectall();
	}
	
	public List<ReservationVO> selectridall(int id) throws Exception {
		return dao.selectridall(id);
	}
	
	public List<ReservationVO> selectcust(String id) throws Exception {
		return dao.selectcust(id);
	}
}