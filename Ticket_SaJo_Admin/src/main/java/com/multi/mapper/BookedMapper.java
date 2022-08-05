package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.BookedVO;

@Repository
@Mapper
public interface BookedMapper {
	public void insert(BookedVO seat) throws Exception;
	public void delete(String id) throws Exception;
	public void update(BookedVO seat) throws Exception;
	
	public BookedVO select(String id) throws Exception;
	public List<BookedVO> selectall() throws Exception;
	
	public List<BookedVO> selectseatlist(int sid, int mcnt) throws Exception;
	
	public Integer selectseatcnt(String id) throws Exception;
}
