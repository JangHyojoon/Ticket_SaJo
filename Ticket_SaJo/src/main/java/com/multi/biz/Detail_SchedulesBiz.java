package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.Detail_SchedulesMapper;
import com.multi.vo.Detail_SchedulesVO;

@Service("detail_schedulebiz")
public class Detail_SchedulesBiz implements Biz<Integer,Detail_SchedulesVO> {

	@Autowired
	Detail_SchedulesMapper dao;
	
	@Override
	public void register(Detail_SchedulesVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(Detail_SchedulesVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer id) throws Exception {
		dao.delete(id);
	}

	@Override
	public Detail_SchedulesVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<Detail_SchedulesVO> get() throws Exception {
		return dao.selectall();
	}
	
	public Detail_SchedulesVO get(Integer sid, Integer mcnt) throws Exception {
		return dao.selectone(sid, mcnt);
	}
	public List<Detail_SchedulesVO> selectsid(Integer sid) throws Exception {
		return dao.selectsid(sid);
	}
	public List<Detail_SchedulesVO> selectmcnt(Integer mcnt) throws Exception {
		return dao.selectmcnt(mcnt);
	}
	public List<Detail_SchedulesVO> selectmiddate(Integer mid,String sdate) throws Exception {
		return dao.selectmiddate(mid, sdate);
		
	}
	public List<Detail_SchedulesVO> selecttidmiddate(Integer tid,Integer mid,String sdate) throws Exception {
		return dao.selecttidmiddate(tid, mid, sdate);
	}
	public Detail_SchedulesVO selectmidtidsdatetime(Integer mid,Integer tid, String sdate, String starttime) throws Exception {
		return dao.selectmidtidsdatetime(mid, tid, sdate, starttime);
	}
}
