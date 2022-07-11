package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.MycouponVO;
import com.multi.vo.ReservationVO;

@Repository
@Mapper
public interface MycouponMapper {
	public void insert(MycouponVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MycouponVO obj) throws Exception;
	
	public MycouponVO select(int id) throws Exception;
	public List<MycouponVO> selectall() throws Exception;

}
