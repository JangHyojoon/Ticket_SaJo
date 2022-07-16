package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.SchedulesMapper;
import com.multi.vo.SchedulesVO;

@Service("schedulebiz")
public class SchedulesBiz implements Biz<Integer,SchedulesVO> {

	@Autowired
	SchedulesMapper dao;
	
	@Override
	public void register(SchedulesVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(SchedulesVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer id) throws Exception {
		dao.delete(id);
	}

	@Override
	public SchedulesVO get(Integer id) throws Exception {
		return dao.select(id);
	}

	@Override
	public List<SchedulesVO> get() throws Exception {
		return dao.selectall();
	}
	
	public List<SchedulesVO> selectmiddate(Integer mid, String sdate) throws Exception {
		return dao.selectmiddate(mid, sdate);
	}
	public List<SchedulesVO> selectmovieonschedules() throws Exception {
		return dao.selectmovieonschedules();
	}

}
