package com.multi.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.BookedBiz;
import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.ReservationBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.TheaterBiz;
import com.multi.biz.TicketBiz;
import com.multi.vo.BookedVO;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.ReservationVO;
import com.multi.vo.SchedulesVO;
import com.multi.vo.TheaterVO;
import com.multi.vo.TicketVO;

@Controller
public class MainController_jhj {
	@Autowired
	BookedBiz seatbiz;
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
	@Autowired
	BookedBiz bookedbiz;
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
	@RequestMapping("/book2")
	public String book2(Model m, int mid, String date,String time,int theater,String msg) {
		
		
		Detail_SchedulesVO dsv = null;
		List<BookedVO> blist = null;
		List<TheaterVO> rows =null;
		List<TheaterVO> columns =null;
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "예매된 좌석입니다. 다른 좌석을 선택해주세요");
	
		}
			
		try {
			//선택된 스케쥴에 해당하는 디테일 스케쥴 정보
			dsv = detail_schedulesbiz.selectmidtidsdatetime(mid, theater, date, time);
			m.addAttribute("book1info", dsv);
			int sid = dsv.getSid();
			int mcnt = dsv.getMcnt();
			blist =bookedbiz.selectseatlist(sid, mcnt);
			m.addAttribute("blist", blist);
			
			//영화관 좌석 행열 정보
			rows = theaterbiz.selectrows(theater);
			m.addAttribute("rows", rows);
			columns = theaterbiz.selectcolumns(theater);
			m.addAttribute("columns", columns);
			
		
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		m.addAttribute("center", "book2");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	
	}
	@RequestMapping("/book3")
	public String book3(Model m, int sid, int mcnt, String starttime, String endtime, String tid, String mid, String sdate,
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
			dsv = detail_schedulesbiz.get(sid, mcnt);
			m.addAttribute("dsv", dsv);
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		m.addAttribute("center", "book3");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	
	}
	@RequestMapping("/book4")
	public String book4(Model m,int rid) {
		
		List<TicketVO> tlist;
		List<ReservationVO> rlist;
		ReservationVO rv;
		try {
			rlist = reservationbiz.selectridall(rid);
			tlist = ticketbiz.selectrid(rid);
			rv = rlist.get(0);
			String rdate = rv.getReleasedate();
			String ryear = rdate.substring(0,4);
			m.addAttribute("rlist", rlist);
			m.addAttribute("tlist", tlist);
			m.addAttribute("ryear", ryear);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		m.addAttribute("center", "book4" );
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
	}
	
	@RequestMapping("/fail")
	public String fail(Model m) {
		return "fail";
	}
	
	@RequestMapping("/book1impl")
	public String book1impl(Model m, int mid, String date,String time,int theater,String msg) {
	
		return "redirect:book2?mid="+mid+"&date="+date+"&time="+time+"&theater="+theater+"&theater="+msg;
	}
	
	@RequestMapping("/book2impl")
	public String book2impl(Model m, int sid, int mcnt, String starttime, String endtime, String tid, String mid, String sdate,
		    String choosen_cost, String choosen_sits) {

		return "redirect:book3?sid="+sid+"&mcnt="+mcnt+"&starttime="+starttime+"&endtime="+endtime+"&tid="+tid+"&mid="+mid+"&sdate="+sdate
				+"&choosen_cost="+choosen_cost+"&choosen_sits="+choosen_sits;
	}

	
	@RequestMapping("/book3impl")
	public String book3mpl(Model m, int sid, int mcnt, String title, int price,String sdate, String seatlist, String uid) {
		//선택좌석 리스트		
		seatlist =seatlist.substring(0,seatlist.length() -1);  
		String sseatlist =seatlist.substring(1,seatlist.length()); 
		String[] bookedarr =sseatlist.split(", ");
		HashSet<String> hashset = new HashSet<>(Arrays.asList(bookedarr));	//중복값 삭제
		String[] choosensit = hashset.toArray(new String[0]);
		Arrays.sort(choosensit);
		//
		
		int mid = 0;
		int rid = 0;
		int theater = 0;
		String time = "";
		Detail_SchedulesVO dsv = null;
		SchedulesVO sv = null;			
		try {
			sv = schedulesbiz.get(sid);	
			mid = sv.getMid();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		
		}
		try {
			dsv = detail_schedulesbiz.get(sid, mcnt);
			theater = dsv.getTid();
			time = dsv.getStarttime();
			
		} catch (Exception e) {
			e.printStackTrace();		

		}
		try {
			bookedbiz.insertseat(sid,mcnt, seatlist);//book테이블 INSERT
			} catch (Exception e2) {
				e2.printStackTrace();
				return "redirect:book1impl?mid="+mid+"&date="+sdate+"&time="+time+"&theater="+theater+"&msg=f";
			}                  //book1impl?mid=1001&date=2022-07-21&time=19%3A00&theater=2
		ReservationVO rv = new ReservationVO(uid,choosensit.length,price,price);	
		try {
			reservationbiz.register(rv);
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
		
		rid = rv.getRid();//ticket테이블 INSERT
	
		for (int i = 0; i < choosensit.length; i++) {
			TicketVO tv = new TicketVO(sid,rid,sdate,mcnt,choosensit[i]);				
			try {
				ticketbiz.register(tv);
			} catch (Exception e) {
				e.printStackTrace();
				
	
			}
		}
	
		return "redirect:/book4?rid="+rid;
		

	}
	

	

}