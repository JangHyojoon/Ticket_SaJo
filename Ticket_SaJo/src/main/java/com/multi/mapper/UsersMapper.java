package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.UserVO;

@Repository
@Mapper
public interface UsersMapper {
	public void insert(UserVO users) throws Exception;
	public void delete(String id) throws Exception;
	public void update(UserVO users) throws Exception;
	
	public UserVO select(String id) throws Exception;
	public List<UserVO> selectall() throws Exception;

}
