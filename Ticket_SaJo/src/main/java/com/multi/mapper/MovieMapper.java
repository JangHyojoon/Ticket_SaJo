package com.multi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.MovieVO;

@Repository
@Mapper
public interface MovieMapper {
	public void insert(MovieVO movie) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MovieVO movie) throws Exception;
	public MovieVO select(int id) throws Exception;
	public List<MovieVO	> selectall() throws Exception;
	//김민식 추가

	public List<MovieVO> selectstar() throws Exception;
	//0713 안원영 추가 
	public List<MovieVO> search(Map<String, String> obj) throws Exception;	
	//0713 안원영 추가 
	public List<MovieVO> selectStarSort() throws Exception;
	

	public List<MovieVO> selectschedules() throws Exception;

	//0714 안원영 추가 
	public List<MovieVO> todayMovieList() throws Exception;
	
	
	
}
