package com.multi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.TheaterBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.SchedulesVO;
import com.multi.vo.TheaterVO;

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
	@RequestMapping("/adddetail")
	public String adddetail(Model m, int sid) {
	
		Integer mid = null;
		List<Detail_SchedulesVO> dslist = null;
		
		MovieVO mv = null;
		SchedulesVO sv = null;
		try {
			m.addAttribute("sid", sid);
			System.out.println(sid);
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
				 mlist.add(element);        }
			
			 m.addAttribute("marr", marr);
			m.addAttribute("mlist", mlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "schedule/adddetail");
	
	
		
		return "index";
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
				System.out.println("ok:"+i);
				try {
					dsbiz.register(dv);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
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
	@RequestMapping("/detail")
	public String detail(Model m, Integer sid,String msg) {
		List<Detail_SchedulesVO> dslist = null;
		SchedulesVO sv = null;
		
		int seatcnt = 0;
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "스케쥴 삭제가 실패했습니다. 발권이 진행된 스케쥴입니다.");
		}
		
		try {
			sv = sbiz.get(sid);
			dslist = dsbiz.selectbookedcnt(sid);
			
			int tid = sv.getTid();
			seatcnt = tbiz.selectseatcnt(tid);
			System.out.println(dslist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "schedule/detail");
		m.addAttribute("sv", sv);
		m.addAttribute("dslist", dslist);
		m.addAttribute("seatcnt", seatcnt);


		return "index";
	}
	@RequestMapping("updatedetailimpl")
	public String updatedetailimpl(Model m, @RequestParam List<String> check, Integer id) {
		Detail_SchedulesVO ds1 = new Detail_SchedulesVO(id, 1,"13:00:00" , "15:00:00");
		Detail_SchedulesVO ds2 = new Detail_SchedulesVO(id, 2,"16:00:00" , "18:00:00");
		Detail_SchedulesVO ds3 = new Detail_SchedulesVO(id, 3,"19:00:00" , "21:00:00");
		try {
			dsbiz.remove(id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (String string : check) {
			if (string.equals("1")) {
				try {
					dsbiz.register(ds1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (string.equals("2")) {
				try {
					dsbiz.register(ds2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (string.equals("3")) {
				try {
					dsbiz.register(ds3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/schedule/list";
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
	@RequestMapping("/delete")
	public String delete(int sid, Model m) {
		try {
			dsbiz.deleteall(sid);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:/schedule/detail?sid="+sid+"&msg=f";
		
		}
		return "redirect:/schedule/calendar";
	}

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
}