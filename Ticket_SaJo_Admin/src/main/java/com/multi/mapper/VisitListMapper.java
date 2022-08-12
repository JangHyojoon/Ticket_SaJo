package com.multi.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.VisitListVO;
import com.multi.vo.VisitVO;

@Repository
@Mapper
public interface VisitListMapper {
	public void insert(VisitListVO visitList) throws Exception;
	public void delete(Date date) throws Exception;
	public void update(VisitListVO visitList) throws Exception;

	public VisitListVO select(Date date) throws Exception;
	
	// 0812 안원영 추가 - 7일간의 방문객 정보 가져오기 
	public List<VisitListVO> VisitList7Days() throws Exception;
	
	// 0812 안원영 추가 - 모든 방문객 합 가져오기 
	public int VisitListAvg() throws Exception;

	public List<VisitListVO> selectall() throws Exception;

}
