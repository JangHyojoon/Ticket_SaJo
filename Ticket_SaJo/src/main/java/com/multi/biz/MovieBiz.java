package com.multi.biz;

import java.util.List;
import java.util.Map;

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

	// 0713 안원영 추가 
	public List<MovieVO> search(Map<String, String> obj) throws Exception {
		return dao.search(obj);
	}
	// 0713 안원영 추가 
	public List<MovieVO> selectStarSort() throws Exception {
		return dao.selectStarSort();

	}
	
	public List<MovieVO> selectschedules() throws Exception {
		return dao.selectschedules();
	}
	
}