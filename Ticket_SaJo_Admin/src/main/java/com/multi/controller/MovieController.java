package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.GenreBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.frame.Util;
import com.multi.vo.AdminVO;
import com.multi.vo.CustVO;
import com.multi.vo.GenreVO;
import com.multi.vo.MovieVO;
import com.multi.vo.ReviewVO;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	MovieBiz mbiz;
	@Autowired
	GenreBiz gbiz;
	@Autowired
	ReviewBiz rbiz;
	
	@RequestMapping("/add")
	public String add(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}
		List<GenreVO> glist = null;
		try {
			glist = gbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movie/add");
		m.addAttribute("glist", glist);
		return "index";
	}
	@RequestMapping("/addimpl")
	public String addimpl(Model m, MovieVO obj) {
		String imgname1 = obj.getMf1().getOriginalFilename();
		String imaname2 = obj.getMf2().getOriginalFilename();
		
		obj.setPosterimg1(imgname1);
		obj.setPosterimg2(imaname2);
		System.out.println(obj.toString());
		try {
			mbiz.register(obj);
			Util.saveFile(obj.getMf1(),admindir,userdir);
			Util.saveFile(obj.getMf2(),admindir,userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movie/addimpl");
		m.addAttribute("movie", obj);
		return "index";
	}
	@RequestMapping("/list")
	public String list(Model m, Integer mnum,HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}else {
		int page = 0;
		List<MovieVO> mlist = null;
		
		try {
			if (mnum != null) {
				page= mnum;
				mlist = mbiz.selectpage(page);
			} else if(mnum == null) {
				mlist = mbiz.selectpage(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("mnum", page);
		m.addAttribute("center", "movie/list");
		m.addAttribute("mlist", mlist);
		return "index";}
	}
	@RequestMapping("/search")
	   public String search(Model m, String text,HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}else {
		List<MovieVO> mlist = null;
		
		try {
			mlist = mbiz.searchall(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movie/search");
		m.addAttribute("mlist", mlist);
		return "index";}
	   }
	@RequestMapping("/detail")
	public String detail(Model m, Integer id) {
		MovieVO movie = null;
		List<GenreVO> glist = null;
		try {
			movie = mbiz.get(id);
			glist = gbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movie/detail");
		m.addAttribute("movie", movie);
		m.addAttribute("glist", glist);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model m, MovieVO movie) {
		System.out.println(movie.toString());
		String imgname1 = movie.getMf1().getOriginalFilename();
		String imaname2 = movie.getMf2().getOriginalFilename();
		
		if(!movie.getMf1().isEmpty()) {
		movie.setPosterimg1(imgname1);
		movie.setPosterimg2(imaname2);
		Util.saveFile(movie.getMf1(),admindir,userdir);
		Util.saveFile(movie.getMf2(),admindir,userdir);
		}
		System.out.println(movie.toString());
		try {
			mbiz.modify(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(Model m, Integer id) {
		
		try {
			mbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@RequestMapping("/reviews")
	public String reviews(Model m, Integer mid) {
		List<ReviewVO> rlist = null;
		try {
			rlist = rbiz.selectmreviews(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "movie/reviews");
		m.addAttribute("rlist", rlist);
		return "index";
	}
	@RequestMapping("/deletereview")
	public String deletereview(Model m, Integer id) {
		try {
			rbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
}