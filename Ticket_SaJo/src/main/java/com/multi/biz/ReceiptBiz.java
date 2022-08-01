package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.ReceiptMapper;
import com.multi.vo.ReceiptVO;

@Service("receiptbiz")
public class ReceiptBiz implements Biz<String,ReceiptVO> {

	@Autowired
	ReceiptMapper dao;
	
	@Override
	public void register(ReceiptVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(ReceiptVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public ReceiptVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReceiptVO> get() throws Exception {
		return dao.selectall();
	}

}