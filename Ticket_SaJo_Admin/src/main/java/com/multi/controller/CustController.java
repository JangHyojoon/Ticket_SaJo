package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.biz.MycouponBiz;
import com.multi.vo.AdminVO;
import com.multi.vo.CustVO;
import com.multi.vo.MovieVO;
import com.multi.vo.MycouponVO;

@Controller
@RequestMapping("/cust")
public class CustController {

	@Autowired
	CustBiz cbiz;
	@Autowired
	MycouponBiz mcbiz;
	
	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("center", "cust/add");
		return "index";
	}
	@RequestMapping("/addimpl")
	public String addimpl(Model m, CustVO cust) {
		
		try {
			cbiz.register(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "cust/addimpl");
		m.addAttribute("cust", cust);
		return "index";
	}
	@RequestMapping("/list")
	public String list(Model m, Integer mnum,HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}else {
		int page = 0;
		List<CustVO> clist = null;
		
		try {
			if (mnum != null) {
				page= mnum;
				clist = cbiz.selectallpage(page);
			} else if(mnum == null) {
				clist = cbiz.selectallpage(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("mnum", page);
		m.addAttribute("center", "cust/list");
		m.addAttribute("clist", clist);
		return "index";}
	}
	@RequestMapping("/search")
	   public String search(Model m, String text,HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}else {
		List<CustVO> clist = null;
		
		try {
			clist = cbiz.searchall(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "cust/search");
		m.addAttribute("clist", clist);
		return "index";}
	   }
	@RequestMapping("/detail")
	public String detail(Model m, String id) {
		CustVO cust = null;
		try {
			cust = cbiz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "cust/detail");
		m.addAttribute("cust", cust);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model m, CustVO cust) {
		
		try {
			cbiz.modify(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(Model m, String id) {
		
		try {
			cbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@RequestMapping("/coupon")
	public String coupon(Model m,String id) {
		List<MycouponVO> mlist = null;
		try {
			mlist = mcbiz.selectuid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mlist.isEmpty()) {
			m.addAttribute("center", "cust/zero");
		}else{
			m.addAttribute("center", "cust/coupon");
		}
		
		m.addAttribute("mlist", mlist);
		return "index";
	}
	@RequestMapping("/cpdelete")
	public String cpdelete(Model m,Integer id,String uid) {
		try {
			mcbiz.remove(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:coupon?id="+uid;
	}
}