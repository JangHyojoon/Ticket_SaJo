package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.GenreVO;

@Repository
@Mapper
public interface GenreMapper {
	public void insert(GenreVO genre) throws Exception;
	public void delete(int id) throws Exception;
	public void update(GenreVO genre) throws Exception;
	public GenreVO select(int id) throws Exception;
	public List<GenreVO	> selectall() throws Exception;

}
