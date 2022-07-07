package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SeatVO;

@Repository
@Mapper
public interface SeatMapper {
	public void insert(SeatVO seat) throws Exception;
	public void delete(String id) throws Exception;
	public void update(SeatVO seat) throws Exception;
	
	public SeatVO select(String id) throws Exception;
	public List<SeatVO> selectall() throws Exception;

}
