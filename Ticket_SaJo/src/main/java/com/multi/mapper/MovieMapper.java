package com.multi.mapper;

import java.util.List;

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

}
