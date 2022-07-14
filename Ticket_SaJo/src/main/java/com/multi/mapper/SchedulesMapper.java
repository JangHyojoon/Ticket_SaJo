package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SchedulesVO;

@Repository
@Mapper
public interface SchedulesMapper {
	public void insert(SchedulesVO schdule) throws Exception;
	public void delete(Integer id) throws Exception;
	public void update(SchedulesVO schdule) throws Exception;
	
	public SchedulesVO select(Integer id) throws Exception;
	public List<SchedulesVO> selectall() throws Exception;
	
	public List<SchedulesVO> selectmiddate(Integer mid,String sdate) throws Exception;
}

