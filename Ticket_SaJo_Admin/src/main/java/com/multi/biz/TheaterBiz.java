package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.TheaterMapper;
import com.multi.vo.TheaterVO;

@Service("theaterbiz")
public class TheaterBiz implements Biz<Integer,TheaterVO> {

	@Autowired
	TheaterMapper dao;
	
	@Override
	public void register(TheaterVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(TheaterVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer id) throws Exception {
		dao.delete(id);
	}

	@Override
	public TheaterVO get(Integer id) throws Exception {
		return dao.select(id);
	}

	@Override
	public List<TheaterVO> get() throws Exception {
		return dao.selectall();
	}
	public List<TheaterVO> selectid(int id) throws Exception {
		return dao.selectid(id);
	}
	
	public TheaterVO selectcnt(int id) throws Exception {
		return dao.selectcnt(id);
	}
	public TheaterVO selectone(int id,String seatid) throws Exception {
		return dao.selectone(id, seatid);
	}
	public List<TheaterVO> selectcolumns(int id) throws Exception {
		return dao.selectcolumns(id);
	}
	public List<TheaterVO> selectrows(int id) throws Exception {
		return dao.selectrows(id);
	}
	public TheaterVO selectseatid(int id,int r, int c) throws Exception {
		return dao.selectseatid(id, r, c);
	}
	public void updateone(TheaterVO theater) throws Exception {
		dao.updateone(theater);
	}
	public Integer selectseatcnt(int id) throws Exception {
		return dao.selectseatcnt(id);
	}
}
