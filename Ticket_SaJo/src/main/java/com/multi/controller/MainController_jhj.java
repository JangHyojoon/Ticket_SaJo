package com.multi.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.ReservationBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.SeatBiz;
import com.multi.biz.TheaterBiz;
import com.multi.biz.TicketBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.ReservationVO;
import com.multi.vo.SchedulesVO;
import com.multi.vo.TheaterVO;
import com.multi.vo.TicketVO;

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
	@Autowired
	ReservationBiz reservationbiz;
	@Autowired
	TicketBiz ticketbiz;
	
	@RequestMapping("/book1")
	public String book1(Model m) {
		
		List<MovieVO> movielist = null;
		List<SchedulesVO> scheduleslist = null;
		List<Detail_SchedulesVO> detail_scheduleslist = null;
		try {
			movielist = moviebiz.get();
			scheduleslist = schedulesbiz.selectmovieonschedules();
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
		TheaterVO tv =null;
		List<TheaterVO> tlist =null;
		List<TheaterVO> rows =null;
		List<TheaterVO> columns =null;
		
		try {
			//선택된 스케쥴에 해당하는 디테일 스케쥴 정보
			dsv = detail_schedulesbiz.selectmidtidsdatetime(mid, theater, date, time);
			m.addAttribute("book1info", dsv);
			
			//영화관 좌석 행열 정보
			rows = theaterbiz.selectrows(theater);
			m.addAttribute("rows", rows);
			columns = theaterbiz.selectcolumns(theater);
			m.addAttribute("columns", columns);
			
			//예약된 좌석 배열
			String booked ="";
			booked = dsv.getBooked();
			String[] bookedarr =booked.split(",");
			m.addAttribute("booked", bookedarr);
			
			
			
		} catch (Exception e) {
			
		}
		m.addAttribute("center", "book2");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	}
	@RequestMapping("/book2impl")
	public String book2impl(Model m, String sid, String mcnt, String starttime, String endtime, String tid, String mid, String sdate,
		    String choosen_cost, String choosen_sits) {
		//선택 좌석 배열
		String[] bookedarr =choosen_sits.split(", ");
		HashSet<String> hashset = 
				new HashSet<>(Arrays.asList(bookedarr));	
		String[] choosensit = hashset.toArray(new String[0]);
		List<String> seatlist = Arrays.asList(choosensit);
		
		m.addAttribute("seatlist", seatlist);
		m.addAttribute("price", choosen_cost);
		Detail_SchedulesVO dsv = null;
		try {
			dsv = detail_schedulesbiz.get(Integer.parseInt(sid), Integer.parseInt(mcnt));
			System.out.println(dsv);
			m.addAttribute("dsv", dsv);
		} catch (Exception e) {

		}
		m.addAttribute("center", "book3");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	}
	@RequestMapping("/book3impl")
	public String book3mpl(Model m, String sid, String mcnt, String title, String price,String sdate, String seatlist) {
		
		ReservationVO rv = new ReservationVO("jhj",Integer.parseInt(mcnt),Integer.parseInt(price),Integer.parseInt(price));
		
		try {
			reservationbiz.register(rv);		
		} catch (Exception e) {

		}
	      
	    

		
		
		m.addAttribute("center", "book4");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
		

	}
	
	
	@RequestMapping("/book22")
	public String book22(Model m) {

		return "book22";
	}


}