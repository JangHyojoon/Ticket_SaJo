package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.MovieMapper;
import com.multi.vo.MovieVO;

@Service("moviebiz")
public class MovieBiz implements Biz<Integer,MovieVO> {

	@Autowired
	MovieMapper dao;
	
	@Override
	public void register(MovieVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(MovieVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public MovieVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<MovieVO> get() throws Exception {
		return dao.selectall();
	}

	
}
