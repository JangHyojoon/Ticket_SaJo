package com.multi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.vo.CustVO;
import com.multi.vo.MovieVO;
import com.multi.vo.ReviewVO;
@Controller
public class MovieController {

	@Autowired
	MovieBiz mbiz;
	@Autowired
	ReviewBiz rbiz;
	@Autowired
	SchedulesBiz sbiz;
	
	
	@RequestMapping("/movielist")
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
			}else if(sort == 4) {
				if (mnum != null) {
					page= mnum;
					mlist = mbiz.sortbyonmovie(page);
				} else if(mnum == null) {
					mlist = mbiz.sortbyonmovie(page);
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
	@RequestMapping("/movielist/detail")
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

	@RequestMapping("/movielist/reviewimpl")
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
