package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.TheaterVO;

@Repository
@Mapper
public interface TheaterMapper {
	public void insert(TheaterVO theater) throws Exception;
	public void delete(int id) throws Exception;
	public void update(TheaterVO theater) throws Exception;
	
	public TheaterVO select(int id) throws Exception;
	public List<TheaterVO> selectall() throws Exception;
	public List<TheaterVO> selectid(int id) throws Exception;

}
