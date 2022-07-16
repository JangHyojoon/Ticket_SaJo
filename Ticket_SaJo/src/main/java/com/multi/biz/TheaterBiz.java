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
	
}
