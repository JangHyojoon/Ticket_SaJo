package com.multi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.BookedBiz;
import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.TheaterBiz;
import com.multi.biz.TicketBiz;
import com.multi.vo.BookedVO;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.SchedulesVO;
import com.multi.vo.TicketVO;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	SchedulesBiz sbiz;
	@Autowired
	MovieBiz mbiz;
	@Autowired
	Detail_SchedulesBiz dsbiz;
	@Autowired 
	TheaterBiz tbiz;
	@Autowired
	BookedBiz bbiz;
	@Autowired
	TicketBiz ticketbiz;
	@RequestMapping("/calendar")
	public String calendar(Model m) {
		List<SchedulesVO> slist =null;
		try {
			slist = sbiz.get();
			m.addAttribute("slist", slist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "schedule/calendar");
		return "index";
	}
	@RequestMapping("/list")
	public String list(Model m, Integer mnum) {
		int page = 0;
		List<SchedulesVO> list = null;
		try {
			if (mnum != null) {
				page= mnum;
				list = sbiz.selectallpage(page);
			} else if(mnum == null) {
				list = sbiz.selectallpage(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("slist", list);
		m.addAttribute("mnum", page);
		m.addAttribute("center", "schedule/list");
		return "index";
	}
	@RequestMapping("/add")
	public String add(Model m) {
		List<SchedulesVO> slist = null;
		List<MovieVO> mlist = null;
		try {
			slist = sbiz.get();
			mlist = mbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "schedule/add");
		m.addAttribute("slist", slist);
		m.addAttribute("mlist", mlist);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model m, Integer id) {
		SchedulesVO schedule = null;
		List<SchedulesVO> slist = null;
		List<MovieVO> mlist = null;
		try {
			schedule = sbiz.get(id);
			slist = sbiz.get();
			mlist = mbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "schedule/update");
		m.addAttribute("slist", slist);
		m.addAttribute("mlist", mlist);
		m.addAttribute("schedule", schedule);
		m.addAttribute("id", id);
		return "index";
	}
	@RequestMapping("/adddetail")
	public String adddetail(Model m, int sid) {
	
		Integer mid = null;
		List<Detail_SchedulesVO> dslist = null;
		
		MovieVO mv = null;
		SchedulesVO sv = null;
		try {
			m.addAttribute("sid", sid);		
			sv = sbiz.get(sid);
			mid = sv.getMid();
			mv = mbiz.get(mid);
			String rt = mv.getRunningtime();
			rt = rt.replace("m", "");
			double runtime = Double.parseDouble(rt);
			runtime = Math.ceil(runtime*0.1)*10;
			int runningtime = (int)runtime;
			m.addAttribute("runningtime", runningtime);
			
			dslist = dsbiz.selectsid(sid);
			int[] marr = new int[dslist.size()];
			
			for (int i = 0; i < dslist.size(); i++) {
				Detail_SchedulesVO dv = null;
				dv = dslist.get(i);
				
				int mcnt = dv.getMcnt();
				
				marr[i] = mcnt;
				
			}
			 List<Integer> mlist = new ArrayList<>();
			 for (int element : marr) {
				 mlist.add(element);
				 }
			
			m.addAttribute("marr", marr);
			m.addAttribute("mlist", mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "schedule/adddetail");
	
	
		
		return "index";
	}
	@RequestMapping("/updatedetail")
	public String updatedetail(Model m, int sid) {
		SchedulesVO sv = null;
		MovieVO mv = null;
		int mid = 0;
		List<Detail_SchedulesVO> dslist = null;
		try {
			m.addAttribute("sid", sid);
			dslist = dsbiz.selectbookedcnt(sid);
			m.addAttribute("dslist", dslist);
			
			//runningtime
			sv = sbiz.get(sid);
			mid = sv.getMid();
			mv = mbiz.get(mid);
			String rt = mv.getRunningtime();
			rt = rt.replace("m", "");
			double runtime = Double.parseDouble(rt);
			runtime = Math.ceil(runtime*0.1)*10;
			int runningtime = (int)runtime;
			m.addAttribute("runningtime", runningtime);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		m.addAttribute("center", "schedule/updatedetail");
	
	
		
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m, Integer sid) {
		List<Detail_SchedulesVO> dslist = null;
		SchedulesVO sv = null;
		List<TicketVO> tlist = null;
		int seatcnt = 0;
		try {
			sv = sbiz.get(sid);
			dslist = dsbiz.selectbookedcnt(sid);
			
			int tid = sv.getTid();
			seatcnt = tbiz.selectseatcnt(tid);
			
			tlist = ticketbiz.selectsid(sid); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "schedule/detail");
		m.addAttribute("sv", sv);
		m.addAttribute("dslist", dslist);
		m.addAttribute("seatcnt", seatcnt);
		m.addAttribute("tlist", tlist);
		return "index";
	}
	@RequestMapping("addimpl")
	public String addimpl(Model m, SchedulesVO schedule) {
		int sid=0;
		try {
			sbiz.register(schedule);
			sid = schedule.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "redirect:/schedule/adddetail?sid="+sid;
	}
	@RequestMapping("/updateimpl")
	public String updateimpl(Model m, SchedulesVO schedule) {
		int sid = schedule.getId();
		try {
			sbiz.modify(schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/schedule/detail?sid="+sid;
	}
	@RequestMapping("adddetailimpl")
	public String adddetailimpl(Model m, String dv1, String dv2, String dv3, String dv4, String dv5, String dv6, String dv7, String dv8, String dv9, String dv10) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, dv1);
		map.put(2, dv2);
		map.put(3, dv3);
		map.put(4, dv4);
		map.put(5, dv5);
		map.put(6, dv6);
		map.put(7, dv7);
		map.put(8, dv8);
		map.put(9, dv9);
		map.put(10, dv10);
		
			for (int i = 1; i < 11; i++) {
			if(map.get(i) != "") {
				String[] darr = map.get(i).split(",");
				
				Detail_SchedulesVO dv = new Detail_SchedulesVO(Integer.parseInt(darr[0]),Integer.parseInt(darr[1]),darr[2],darr[3]);
			
				try {
					dsbiz.register(dv);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}	
		return "redirect:/schedule/calendar";
	}
	@RequestMapping("updatedetailimpl")
	public String updatedetailimpl(Model m,int sid, String dv1, String dv2, String dv3, String dv4, String dv5, String dv6, String dv7, String dv8, String dv9, String dv10) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, dv1);
		map.put(2, dv2);
		map.put(3, dv3);
		map.put(4, dv4);
		map.put(5, dv5);
		map.put(6, dv6);
		map.put(7, dv7);
		map.put(8, dv8);
		map.put(9, dv9);
		map.put(10, dv10);
		
		Detail_SchedulesVO dv =null;
		List<BookedVO> blist = null;
		int mcnt = 0;
		String starttime= "";
		String endtime="";
		
		for (int i = 1; i < 11; i++) {
			try {
				dsbiz.deletesidmcnt(sid,i);
			} catch (Exception e) {		
				e.printStackTrace();
			}

		}
		for (int i = 1; i < 11; i++) {
			if(map.get(i) != "" && map.get(i) != null) {
				String[] darr = map.get(i).split(",");	
				mcnt = Integer.parseInt(darr[0]);
				starttime =darr[1];
				endtime=darr[2];
				try {
				
					dsbiz.deletesidmcnt(sid,mcnt);
					dv = new Detail_SchedulesVO(sid,mcnt,starttime,endtime);
					dsbiz.register(dv);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	return "redirect:/schedule/detail?sid="+sid;
	}
	@RequestMapping("/delete")
	public String delete(int id, Model m) {
		try {
			dsbiz.deleteall(id);
		} catch (Exception e) {

		}
		return "redirect:/schedule/calendar";
	}


	
}