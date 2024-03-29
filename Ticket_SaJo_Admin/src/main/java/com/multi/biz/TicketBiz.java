package com.multi.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.TicketMapper;
import com.multi.vo.TicketVO;

@Service("ticket")
public class TicketBiz implements Biz<Integer,TicketVO> {

	@Autowired
	TicketMapper dao;
	
	@Override
	public void register(TicketVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(TicketVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public TicketVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<TicketVO> get() throws Exception {
		return dao.selectall();
	}
	public List<TicketVO> selectrid(Integer rid) throws Exception{
		return dao.selectrid(rid);
	}
	public List<TicketVO> selectsid(Integer sid) throws Exception{
		return dao.selectsid(sid);
	}
	
	//0811 안원영 추가 - 오늘 예약 수
	public int todayticketBuyCnt(Date date) throws Exception {
		return dao.todayticketBuyCnt(date);
	}
}
