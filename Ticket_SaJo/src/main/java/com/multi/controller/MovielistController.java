package com.multi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.vo.CustVO;
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
	public String movielist(Model m,Integer mnum,Integer sort) {
		int page = 0;
		if(sort == null) {
			sort = 0;
		}
		int typesort = sort;
		List<MovieVO> mlist = null;
		List<MovieVO> schedules = null;
		try {
			schedules = mbiz.selectschedules();
			if(sort == 0) {
				if (mnum != null) {
					page= mnum;
					mlist = mbiz.selectpage(page);
				} else if(mnum == null) {
					mlist = mbiz.selectpage(page);
				}
			}else if(sort == 1) {
				if (mnum != null) {
					page= mnum;
					mlist = mbiz.sortbyreleasedate(page);
				} else if(mnum == null) {
					mlist = mbiz.sortbyreleasedate(page);
				}
			}else if(sort == 2) {
				if (mnum != null) {
					page= mnum;
					Map<String, Integer> map = new HashMap<String, Integer>();
					map.put("mnum1", page);
					map.put("mnum2", 3);
					mlist = mbiz.selectrankpage(map);
				} else if(mnum == null) {
					Map<String, Integer> map = new HashMap<String, Integer>();
					map.put("mnum1", page);
					map.put("mnum2", 3);
					mlist = mbiz.selectrankpage(map);
				}
			}else if(sort == 3) {
				if (mnum != null) {
					page= mnum;
					mlist = mbiz.sortbyrcnt(page);
				} else if(mnum == null) {
					mlist = mbiz.sortbyrcnt(page);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("sort",typesort);
		m.addAttribute("mnum", page);
		m.addAttribute("center", "movielist/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("schedules", schedules);
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m,Integer id,HttpSession session) {
		CustVO ncust = (CustVO) session.getAttribute("user");
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
	@RequestMapping("/reviewimpl")
	public String reviewimpl(Model m,ReviewVO review) {
		int id = 0;
		try {
			id = review.getMid();
			rbiz.register(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/movielist/detail?id="+id;
	}
	
}
