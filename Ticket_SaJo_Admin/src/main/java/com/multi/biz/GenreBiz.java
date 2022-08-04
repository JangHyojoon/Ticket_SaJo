package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.GenreMapper;
import com.multi.vo.GenreVO;

@Service("genrebiz")
public class GenreBiz implements Biz<Integer,GenreVO> {

	@Autowired
	GenreMapper dao;
	
	@Override
	public void register(GenreVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(GenreVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public GenreVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<GenreVO> get() throws Exception {
		return dao.selectall();
	}

	
}
