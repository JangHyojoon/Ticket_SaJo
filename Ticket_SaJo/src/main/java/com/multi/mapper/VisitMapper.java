package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.VisitVO;

@Repository
@Mapper
public interface VisitMapper {
	public void insert(VisitVO visit) throws Exception;
	public void delete(String id) throws Exception;
	public void update(VisitVO visit) throws Exception;
	// 0810 안원영 추가 - 방문자수 증가 
	public void updateCount(String id) throws Exception;
	public VisitVO select(String id) throws Exception;
	// 0810 안원영 추가 - 하루의 방문자수 모두 더하기 
	public int SumCount() throws Exception;
	public List<VisitVO> selectall() throws Exception;

}
