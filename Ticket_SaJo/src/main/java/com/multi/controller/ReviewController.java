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
		int rankcnt = 0;
		List<MovieVO> starSortList = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		
		try {
			rankcnt = mbiz.selectrankcnt();// 현재 리뷰가 있는 영화의 갯수중 중복제거 갯수 - 몇순위 까지 있는지  
			
//			System.out.println("mnum : " + mnum);
//			System.out.println("rankcnt : " + rankcnt);
			
			if (mnum != null) {// 페이지 넘김 버튼 클릭시 호출 
				page = mnum;
				map.put("mnum1", page);
				map.put("mnum2", 5);// 3개의 정보만 가져온다. 
				
				starSortList = mbiz.selectrankpage(map);
//				System.out.println("starSortList : " + starSortList);
				
				
			} else if(mnum == null) {// 처음 reviewrank 페이지 들어왔을 경우
				page = 0;
				map.put("mnum1", page);
				map.put("mnum2", 5);
				starSortList = mbiz.selectrankpage(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("mnum", page);
		m.addAttribute("center", "/reviewrank/rank");
		m.addAttribute("starSortList", starSortList);//rank 순위별 5개 정보저장 
		m.addAttribute("rankcnt", rankcnt); // rank 가 총 몇개인지 저장 - > NEXT 버튼 처리시 사용 
		return "index";
	}




}
