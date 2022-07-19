package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@Controller
public class MainController {

	@Autowired
	MovieBiz mbiz;
	
	@RequestMapping("/")
	public String main(Model m) {
		List<MovieVO> starSortList = null;
		List<MovieVO> todayMovieList = null;
		
		try {
			starSortList = mbiz.selectStarSort();
			todayMovieList = mbiz.todayMovieList();
//			System.out.println("todayMovieList : " + todayMovieList);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		m.addAttribute("starSortList", starSortList);
		m.addAttribute("todayMovieList", todayMovieList);
		
		return "index";
	}
	
	
}