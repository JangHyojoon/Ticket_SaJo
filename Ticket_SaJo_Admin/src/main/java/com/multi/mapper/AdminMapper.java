package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AdminVO;

@Repository
@Mapper
public interface AdminMapper {
	public void insert(AdminVO admin) throws Exception;
	public void delete(String id) throws Exception;
	public void update(AdminVO admin) throws Exception;
	public AdminVO select(String id) throws Exception;
	public List<AdminVO> selectall() throws Exception;

	
}
