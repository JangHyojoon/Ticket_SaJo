package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.UsersMapper;
import com.multi.vo.UserVO;

@Service("usersbiz")
public class UsersBiz implements Biz<String,UserVO> {

	@Autowired
	UsersMapper dao;
	
	@Override
	public void register(UserVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(UserVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public UserVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<UserVO> get() throws Exception {
		return dao.selectall();
	}

	
}
