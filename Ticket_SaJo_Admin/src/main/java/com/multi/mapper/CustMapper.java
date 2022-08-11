package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CustVO;

@Repository
@Mapper
public interface CustMapper {
	public void insert(CustVO users) throws Exception;
	public void delete(String id) throws Exception;
	public void update(CustVO users) throws Exception;
	public CustVO select(String id) throws Exception;
	public List<CustVO> selectall() throws Exception;
	public void updatecust(CustVO users) throws Exception;

	public void usepoint(String id,int usepoint) throws Exception;
	public List<CustVO> selectallpage(Integer mnum) throws Exception;
	public List<CustVO> searchall(String text) throws Exception;
	
	//0811 안원영 추가 - 회원수 출력 
	public int selectCustCnt() throws Exception;
	
	//0811 안원영 추가 - 탈퇴 회원수 출력 
	public int selectExitCnt() throws Exception;
}
