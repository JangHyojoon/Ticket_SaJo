package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.GenreBiz;
import com.multi.vo.GenreVO;

@Controller
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	GenreBiz gbiz;
	
	@RequestMapping("/add")
	public String add(Model m) {
		List<GenreVO> glist = null;
		try {
			glist = gbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "genre/add");
		m.addAttribute("glist", glist);
		return "index";
	}
	@RequestMapping("addimpl")
	public String addimpl(Model m, GenreVO obj) {
		try {
			gbiz.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/genre/list";
	}
	@RequestMapping("/list")
	public String list(Model m) {
		List<GenreVO> list = null;
		try {
			list = gbiz.get();
			m.addAttribute("glist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "genre/list");
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m, Integer id) {
		List<GenreVO> glist = null;
		GenreVO genre = null;
		try {
			glist = gbiz.get();
			genre = gbiz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "genre/detail");
		m.addAttribute("glist", glist);
		m.addAttribute("genre", genre);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model m,GenreVO obj) {
		m.addAttribute("center", "genre/detail");
		try {
			gbiz.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/genre/list";
	}
	@RequestMapping("/delete")
	public String delete(int id, Model m) {
		try {
			gbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:detail?id="+id;
		}
		return "redirect:/genre/list";
	}
	
}