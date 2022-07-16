package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.SeatBiz;
import com.multi.biz.TheaterBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.SchedulesVO;
import com.multi.vo.SeatVO;
import com.multi.vo.TheaterVO;

@Controller
public class MainController_jhj {
	@Autowired
	SeatBiz seatbiz;
	@Autowired
	TheaterBiz theaterbiz;
	@Autowired
	MovieBiz moviebiz;
	@Autowired
	SchedulesBiz schedulesbiz;
	@Autowired
	Detail_SchedulesBiz detail_schedulesbiz;
	@RequestMapping("/book1")
	public String book1(Model m) {
		
		List<MovieVO> movielist = null;
		List<SchedulesVO> scheduleslist = null;
		List<Detail_SchedulesVO> detail_scheduleslist = null;
		try {
			movielist = moviebiz.get();
			scheduleslist = schedulesbiz.get();
			detail_scheduleslist = detail_schedulesbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("movielist", movielist);
		m.addAttribute("scheduleslist", scheduleslist);
		m.addAttribute("detail_scheduleslist", detail_scheduleslist);
		m.addAttribute("center", "book1");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		
		return "index";
	}

	@RequestMapping("/book1impl")
	public String book1impl(Model m, int mid, String date,String time,int theater) {
		Detail_SchedulesVO dsv = null;
		List<TheaterVO> theaterlist = null;
		List<SeatVO> seatlist = null;
		try {
			dsv = detail_schedulesbiz.selectmidtidsdatetime(mid, theater, date, time);
			m.addAttribute("book1info", dsv);
			theaterlist = theaterbiz.selectid(theater);
			m.addAttribute("theater", theaterlist);
			seatlist = seatbiz.get();
			m.addAttribute("seat", seatlist);
		} catch (Exception e) {
			
		}
		m.addAttribute("center", "book2");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	}


	@RequestMapping("/elements")
	public String elements(Model m) {

		return "elements";
	}


}