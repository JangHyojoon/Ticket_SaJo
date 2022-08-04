package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.PointlistMapper;
import com.multi.vo.PointlistVO;

@Service("pointlistbiz")
public class PointlistBiz implements Biz<Integer,PointlistVO> {

	@Autowired
	PointlistMapper dao;
	
	@Override
	public void register(PointlistVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(PointlistVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public PointlistVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<PointlistVO> get() throws Exception {
		return dao.selectall();
	}
	
	public List<PointlistVO> selectpoint(String id) throws Exception{
		return dao.selectpoint(id)	;	
	}
}