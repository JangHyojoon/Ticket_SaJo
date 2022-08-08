package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CodeVO;

@Repository
@Mapper
public interface CodeMapper {
	public void insert(CodeVO code) throws Exception;
	public void delete(Integer id) throws Exception;
	public void update(CodeVO code) throws Exception;
	public CodeVO select(Integer id) throws Exception;
	public CodeVO selectcode(String code) throws Exception;
	public List<CodeVO> selectall() throws Exception;
	public void autoupdate() throws Exception;
	
}
