package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.Detail_reservationMapper;
import com.multi.vo.Detail_reservationVO;

@Service("detail_reservationbiz")
public class Detail_reservationBiz implements Biz<Integer,Detail_reservationVO> {

	@Autowired
	Detail_reservationMapper dao;
	
	@Override
	public void register(Detail_reservationVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(Detail_reservationVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public Detail_reservationVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<Detail_reservationVO> get() throws Exception {
		return dao.selectall();
	}

	
}
