package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.ReviewVO;

@Repository
@Mapper
public interface ReviewMapper {
	public void insert(ReviewVO review) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ReviewVO review) throws Exception;
	public ReviewVO select(int id) throws Exception;
	public List<ReviewVO> selectall() throws Exception;
	public List<ReviewVO> selectmreviews(int mid) throws Exception;
	//0718 김민식추가
	public List<ReviewVO> selectbyage(int mid) throws Exception;
	public List<ReviewVO> selectbysex(int mid) throws Exception;
}
