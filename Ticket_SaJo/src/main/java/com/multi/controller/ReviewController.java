package com.multi.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;
@Controller

public class ReviewController {

	@Autowired
	MovieBiz mbiz;

	@RequestMapping("/reviewrank")
	public String reviewrank(Model m,Integer mnum) {
		int page = 0;
		List<MovieVO> schedules = null;
		List<MovieVO> starSortList = null;
		System.out.println("mnum : " + mnum);
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			if (mnum != null) {// 페이지 넘김 버튼 클릭시 호출 
				page = mnum;
				map.put("mnum1", page);
				map.put("mnum2", page+3);
				
				starSortList = mbiz.selectrankpage(map);
				
			} else if(mnum == null) {// 처음 reviewrank 페이지 들어왔을 경우
				page = 0;
				map.put("mnum1", page);
				map.put("mnum2", page+3);
				starSortList = mbiz.selectrankpage(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("mnum", page);
		m.addAttribute("center", "/reviewrank/rank");
		m.addAttribute("starSortList", starSortList);
		return "index";
	}




}
