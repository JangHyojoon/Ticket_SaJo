package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.PointlistVO;

@Repository
@Mapper
public interface PointlistMapper {
	
	public void insert(PointlistVO point) throws Exception;
	public void delete(int id) throws Exception;
	public void update(PointlistVO point) throws Exception;
	public PointlistVO select(int id) throws Exception;
	public List<PointlistVO> selectall() throws Exception;
	public List<PointlistVO> selectpoint(String id) throws Exception;
	public PointlistVO selectprice(String id) throws Exception;
}
