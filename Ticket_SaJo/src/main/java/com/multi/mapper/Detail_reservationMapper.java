package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.Detail_reservationVO;

@Repository
@Mapper
public interface Detail_reservationMapper {
	public void insert(Detail_reservationVO genre) throws Exception;
	public void delete(int id) throws Exception;
	public void update(Detail_reservationVO genre) throws Exception;
	public Detail_reservationVO select(int id) throws Exception;
	public List<Detail_reservationVO> selectall() throws Exception;

}
