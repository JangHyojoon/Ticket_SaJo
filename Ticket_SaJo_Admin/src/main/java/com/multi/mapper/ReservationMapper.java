package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.ReservationVO;

@Repository
@Mapper
public interface ReservationMapper {
	public void insert(ReservationVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ReservationVO obj) throws Exception;
	public ReservationVO select(int id) throws Exception;
	public List<ReservationVO> selectall() throws Exception;
	public List<ReservationVO> selectridall(int id) throws Exception;
	public List<ReservationVO> selectcust(String id) throws Exception;
}
