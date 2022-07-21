package com.multi.biz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.frame.Biz;
import com.multi.mapper.BookedMapper;
import com.multi.vo.BookedVO;

@Service("bookedbiz")
public class BookedBiz implements Biz<String,BookedVO> {

	@Autowired
	BookedMapper dao;
	
	@Override
	public void register(BookedVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(BookedVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String id) throws Exception {
		dao.delete(id);
	}

	@Override
	public BookedVO get(String id) throws Exception {
		return dao.select(id);
	}

	@Override
	public List<BookedVO> get() throws Exception {
		return dao.selectall();
	}
	@Transactional
	public void insertseat(int sid, int mcnt, String seatlist) throws Exception {
		//선택좌석 리스트
		System.out.println(seatlist);
	
		String sseatlist =seatlist.substring(1,seatlist.length()); 
		String[] bookedarr =sseatlist.split(", ");
		HashSet<String> hashset = new HashSet<>(Arrays.asList(bookedarr));	//중복값 삭제
		String[] choosensit = hashset.toArray(new String[0]);
		Arrays.sort(choosensit);
		
		for (int i = 0; i < choosensit.length; i++) {
		
			BookedVO bv = new BookedVO(sid,mcnt,choosensit[i]);
			dao.insert(bv);
			
		}
	}
	
}
