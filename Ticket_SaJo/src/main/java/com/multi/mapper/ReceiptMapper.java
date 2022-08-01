package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.ReceiptVO;

@Repository
@Mapper
public interface ReceiptMapper {
	public void insert(ReceiptVO review) throws Exception;
	public void delete(String id) throws Exception;
	public void update(ReceiptVO review) throws Exception;
	public ReceiptVO select(String id) throws Exception;
	public List<ReceiptVO> selectall() throws Exception;

}
