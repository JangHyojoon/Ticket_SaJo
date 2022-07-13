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
public class SearchController {

	@Autowired
	MovieBiz mbiz;
	
	@RequestMapping("/searchcategory")
	public String movielist(Model m,String searchtxt) {
		List<MovieVO> mlist = null;
		Map<String, String> map = new HashMap<String, String>();// 검색 키워드 저장할 map
		

		System.out.println("searchtxt : "+ searchtxt);
		try {
			map.put("searchfield", "category");// 검색 종류 값 설정
			map.put("searchtxt", searchtxt); // 검색 값 설정
			
			System.out.println(map);
			mlist = mbiz.search(map);
			System.out.println("mlist : " + mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/search/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("searchtxt", searchtxt);
		return "index";
	}
	
	@RequestMapping("/searchactors")
	public String searchactors(Model m,String searchtxt) {
		List<MovieVO> mlist = null;
		Map<String, String> map = new HashMap<String, String>();// 검색 키워드 저장할 map
		

		System.out.println("searchtxt : "+ searchtxt);
		try {
			map.put("searchfield", "actors");// 검색 종류 값 설정 - ex) bibian
			map.put("searchtxt", searchtxt); // 검색 값 설정
			
			System.out.println(map);
			mlist = mbiz.search(map);
			System.out.println("mlist : " + mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/search/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("searchtxt", searchtxt);
		return "index";
	}
	
	@RequestMapping("/searchdirector")
	public String searchdirector(Model m,String searchtxt) {
		List<MovieVO> mlist = null;
		Map<String, String> map = new HashMap<String, String>();// 검색 키워드 저장할 map
		

		System.out.println("searchtxt : "+ searchtxt);
		try {
			map.put("searchfield", "director");// 검색 종류 값 설정 - ex) victor
			map.put("searchtxt", searchtxt); // 검색 값 설정
			
			System.out.println(map);
			mlist = mbiz.search(map);
			System.out.println("mlist : " + mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/search/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("searchtxt", searchtxt);
		return "index";
	}
	
	@RequestMapping("/searchcountry")// 한국 미국 
	public String searchcountry(Model m,String searchtxt) {
		List<MovieVO> mlist = null;
		Map<String, String> map = new HashMap<String, String>();// 검색 키워드 저장할 map
		

		System.out.println("searchtxt : "+ searchtxt);
		try {
			map.put("searchfield", "country");// 검색 종류 값 설정 - ex) kor
			map.put("searchtxt", searchtxt); // 검색 값 설정
			
			System.out.println(map);
			mlist = mbiz.search(map);
			System.out.println("mlist : " + mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/search/movielist");
		m.addAttribute("movie", mlist);
		m.addAttribute("searchtxt", searchtxt);
		return "index";
	}
	
	

}
