package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@Controller
public class MainController_awy {
	
	@Autowired
	MovieBiz mbiz;
	

	@RequestMapping("/searchcategory")//동일한 이름만 서치 가능 
	public String searchcategory(Model m,String txt) {
	    System.out.println("search Start : ");
	    List<MovieVO> list = null;
	    MovieVO movie = null;

	    try {
//	        list = mbiz.searchproduct(txt);
	        m.addAttribute("productlist", list);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    m.addAttribute("center", "search");

	    return "index";
	}
	
	@RequestMapping("/searchactors")//동일한 이름만 서치 가능 
	public String searchactors(Model m,String txt) {
	    System.out.println("search Start : ");
	    List<MovieVO> list = null;
	    MovieVO movie = null;

	    try {
//	        list = mbiz.searchproduct(txt);
	        m.addAttribute("productlist", list);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    m.addAttribute("center", "search");

	    return "index";
	}
	
	@RequestMapping("/searchdirector")//동일한 이름만 서치 가능 
	public String searchdirector(Model m,String txt) {
	    System.out.println("search Start : ");
	    List<MovieVO> list = null;
	    MovieVO movie = null;

	    try {
//	        list = mbiz.searchproduct(txt);
	        m.addAttribute("productlist", list);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    m.addAttribute("center", "search");

	    return "index";
	}
	
	@RequestMapping("/searchcountry")//동일한 이름만 서치 가능 
	public String searchcountry(Model m,String txt) {
	    System.out.println("search Start : ");
	    List<MovieVO> list = null;
	    MovieVO movie = null;

	    try {
//	        list = mbiz.searchproduct(txt);
	        m.addAttribute("productlist", list);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    m.addAttribute("center", "search");

	    return "index";
	}


}