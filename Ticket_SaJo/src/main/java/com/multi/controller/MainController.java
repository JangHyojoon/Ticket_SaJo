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
public class MainController {

	@Autowired
	MovieBiz mbiz;
	
	@RequestMapping("/")
	public String main(Model m) {
		List<MovieVO> starSortList = null;
		List<MovieVO> todayMovieList = null;
		
		try {
			starSortList = mbiz.selectStarSort();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		m.addAttribute("starSortList", starSortList);
		
		return "index";
	}
}