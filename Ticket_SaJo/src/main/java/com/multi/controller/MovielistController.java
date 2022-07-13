package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;
@Controller
@RequestMapping("/movielist")
public class MovielistController {

	@Autowired
	MovieBiz mbiz;
	
	@RequestMapping("")
	public String movielist(Model m) {
		List<MovieVO> mlist = null;
		List<MovieVO> schedules = null;
		try {
			schedules = mbiz.selectschedules();
			mlist = mbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movielist/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("schedules", schedules);
		return "index";
	}
	@RequestMapping("/moviedetail")
	public String moviedetail(Model m) {
		m.addAttribute("center", "movielist/moviedetail");

		return "index";
	}
}
