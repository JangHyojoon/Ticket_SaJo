package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CouponVO;
import com.multi.vo.MycouponVO;
import com.multi.vo.ReservationVO;

@Repository
@Mapper
public interface CouponMapper {
	public void insert(CouponVO obj) throws Exception;
	public void delete(String id) throws Exception;
	public void update(CouponVO  obj) throws Exception;
	
	public CouponVO  select(String id) throws Exception;
	public List<CouponVO> selectall() throws Exception;
	
	// 0722 안원영 추가 - 쿠폰 정렬
	public List<CouponVO> selectsortall() throws Exception;

}
