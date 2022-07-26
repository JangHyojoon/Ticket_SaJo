package com.multi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.MycouponVO;

@Repository
@Mapper
public interface MycouponMapper {
	public void insert(MycouponVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MycouponVO obj) throws Exception;
	public MycouponVO select(int id) throws Exception;
	public List<MycouponVO> selectall() throws Exception;
	public List<MycouponVO> selectKeepCoupon(Map<String,Object> map) throws Exception;

	// 0725 안원영 수정 - 티켓결제에 쿠폰 결합
	public List<MycouponVO> selectUsableCoupon(String uid) throws Exception;
	
}
