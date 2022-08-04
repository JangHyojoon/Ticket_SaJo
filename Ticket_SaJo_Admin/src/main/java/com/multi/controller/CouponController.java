package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CouponBiz;
import com.multi.vo.CouponVO;
import com.multi.vo.CustVO;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponBiz cpbiz;
	
	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("center", "coupon/add");
		return "index";
	}
	@RequestMapping("/addimpl")
	public String addimpl(Model m, CouponVO coupon) {
		
		try {
			cpbiz.register(coupon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:list";
	}
	@RequestMapping("/list")
	public String list(Model m) {
		List<CouponVO> clist = null;
		try {
			clist = cpbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "coupon/list");
		m.addAttribute("clist", clist);
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m, Integer id) {
		CouponVO coupon = null;
		try {
			coupon = cpbiz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "coupon/detail");
		m.addAttribute("coupon", coupon);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model m, CouponVO coupon) {
		try {
			cpbiz.modify(coupon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(Model m, Integer id) {
		
		try {
			cpbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
}