package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CodeMapper;
import com.multi.vo.CodeVO;

@Service("codebiz")
public class CodeBiz implements Biz<Integer,CodeVO> {

	@Autowired
	CodeMapper dao;
	
	@Override
	public void register(CodeVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(CodeVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public CodeVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CodeVO> get() throws Exception {
		return dao.selectall();
	}
	public CodeVO selectcode(String code) throws Exception {
		return dao.selectcode(code);
	}
	public void autoupdate() throws Exception {
		dao.autoupdate();
	}
}
