package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.vo.MovieVO;
import com.multi.vo.ReviewVO;
@Controller
@RequestMapping("/movielist")
public class MovielistController {

	@Autowired
	MovieBiz mbiz;
	@Autowired
	ReviewBiz rbiz;
	
	@RequestMapping("")
	public String movielist(Model m,Integer id) {
		int fid = 1000;
		List<MovieVO> mlist = null;
		List<MovieVO> schedules = null;
		try {
			schedules = mbiz.selectschedules();
			if (id != null) {
				fid = id;
				mlist = mbiz.selectpage(id);
			} else if(id == null) {
				mlist = mbiz.selectpage(fid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("mnum", fid);
		m.addAttribute("center", "movielist/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("schedules", schedules);
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m,Integer id) {
		List<ReviewVO> rlist = null;
		MovieVO movie;
		try {
			rlist = rbiz.selectmreviews(id);
			movie = mbiz.get(id);
			m.addAttribute("movie", movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("reviews", rlist);
		m.addAttribute("center", "movielist/moviedetail");
		return "/index";
	}
	@RequestMapping("/movie")
	public String movie(Model m) {
		m.addAttribute("center", "movielist/movie-page-full");
		return "index";
	}
	
}
