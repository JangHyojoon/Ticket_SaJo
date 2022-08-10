package com.multi.mapper;

import java.util.Date;
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
	public List<SchedulesVO> selectmovieonschedules() throws Exception;
	public List<SchedulesVO> movielistschedule(Integer mid,String sdate) throws Exception;
	public List<SchedulesVO> selectallpage(Integer mnum) throws Exception;
	
	
	// 0810 안원영 추가 - 오늘 상영영화 수 
	public int todayMovieCnt(Date date) throws Exception;
}

