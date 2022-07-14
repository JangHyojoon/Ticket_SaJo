package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.Detail_SchedulesVO;

@Repository
@Mapper
public interface Detail_SchedulesMapper {
	public void insert(Detail_SchedulesVO v) throws Exception;
	public void delete(Integer k) throws Exception;
	public void update(Detail_SchedulesVO v) throws Exception;
	
	public Detail_SchedulesVO select(Integer k) throws Exception;
	public List<Detail_SchedulesVO> selectall() throws Exception;
	
	public Detail_SchedulesVO selectone(Integer sid,Integer mcnt) throws Exception;
	public List<Detail_SchedulesVO> selectsid(Integer sid) throws Exception;
	public List<Detail_SchedulesVO> selectmcnt(Integer mcnt) throws Exception;
	public List<Detail_SchedulesVO> selectmiddate(Integer mid,String sdate) throws Exception;
	public List<Detail_SchedulesVO> selecttidmiddate(Integer tid,Integer mid,String sdate) throws Exception;
}
