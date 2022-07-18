package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.ReviewMapper;
import com.multi.vo.ReviewVO;

@Service("reviewbiz")
public class ReviewBiz implements Biz<Integer,ReviewVO> {

	@Autowired
	ReviewMapper dao;
	
	@Override
	public void register(ReviewVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(ReviewVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public ReviewVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReviewVO> get() throws Exception {
		return dao.selectall();
	}
	public List<ReviewVO> selectmreviews(Integer k) throws Exception{
		return dao.selectmreviews(k);
	}
	public List<ReviewVO> selectbyage(Integer k) throws Exception{
		return dao.selectbyage(k);
	}
	public List<ReviewVO> selectbysex(Integer k) throws Exception{
		return dao.selectbysex(k);
	}

}