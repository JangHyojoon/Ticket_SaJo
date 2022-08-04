package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.GenreBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.GenreVO;
import com.multi.vo.MovieVO;
import com.multi.vo.SchedulesVO;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	SchedulesBiz sbiz;
	@Autowired
	MovieBiz mbiz;
	@Autowired
	Detail_SchedulesBiz dsbiz;
	
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
	@RequestMapping("/adddetail")
	public String adddetail(Model m, SchedulesVO schedule) {
		Integer sid = null;
		try {
			sbiz.register(schedule);
			sid = schedule.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "schedule/adddetail");
		m.addAttribute("sid", sid);
		return "index";
	}
	@RequestMapping("addimpl")
	public String addimpl(Model m, @RequestParam List<String> check, Integer id) {
		Detail_SchedulesVO ds1 = new Detail_SchedulesVO(id, 1,"13:00:00" , "15:00:00");
		Detail_SchedulesVO ds2 = new Detail_SchedulesVO(id, 2,"16:00:00" , "18:00:00");
		Detail_SchedulesVO ds3 = new Detail_SchedulesVO(id, 3,"19:00:00" , "21:00:00");
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
	public String detail(Model m, Integer sid) {
		List<Detail_SchedulesVO> dlist = null;
		Integer id1 = 0;
		Integer id2 = 0;
		Integer id3 = 0;
		
		System.out.println(sid);
			try {
				dlist = dsbiz.selectsid(sid);
				for (Detail_SchedulesVO detail_SchedulesVO : dlist) {
					if (detail_SchedulesVO.getMcnt()==1) {
						id1 = 1;
					}
					if (detail_SchedulesVO.getMcnt()==2) {
						id2 = 1;
					}
					if (detail_SchedulesVO.getMcnt()==3) {
						id3 = 1;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		m.addAttribute("center", "schedule/detail");
		m.addAttribute("dlist", dlist);
		m.addAttribute("id1", id1);
		m.addAttribute("id2", id2);
		m.addAttribute("id3", id3);
		m.addAttribute("sid", sid);

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
		try {
			sbiz.modify(schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/schedule/list";
	}
	@RequestMapping("/delete")
	public String delete(int id, Model m) {
		try {
			dsbiz.remove(id);
			sbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:detail?id="+id;
		}
		return "redirect:/schedule/list";
	}
}