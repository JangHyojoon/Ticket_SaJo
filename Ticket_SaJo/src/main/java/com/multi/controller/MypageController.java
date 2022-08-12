package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.biz.MycouponBiz;
import com.multi.biz.PointlistBiz;
import com.multi.biz.ReservationBiz;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;
import com.multi.vo.PointlistVO;
import com.multi.vo.ReservationVO;


@Controller
public class MypageController {
   
   @Autowired
   CustBiz custbiz;
   
   @Autowired
   ReservationBiz rbiz;
   
   @Autowired
   PointlistBiz pbiz;
   
   @Autowired
   MycouponBiz cbiz;
   
 
   @RequestMapping("/mypage")

   public String mypage(Model m, HttpSession session) {
	   List<ReservationVO> list1 = null;	   
	   List<PointlistVO> list2 = null; 
	   List<MycouponVO> list3= null;	  
	   MycouponVO couponcnt = null;
	   PointlistVO pointprice = null;
	   CustVO cust = (CustVO) session.getAttribute("user");
	      try {
	         list1 = rbiz.selectcust(cust.getId());
	         list2 = pbiz.selectpoint(cust.getId());
	         list3 = cbiz.selectmycoupon(cust.getId());
	         couponcnt = cbiz.selectcnt(cust.getId());
	         pointprice = pbiz.selectprice(cust.getId());
	         m.addAttribute("reservationlist", list1);
	         m.addAttribute("pointlist", list2);
	         m.addAttribute("mycouponlist", list3);
	         m.addAttribute("couponcnt", couponcnt);
	         m.addAttribute("pointprice", pointprice);
	      } catch (Exception e) {
	          e.printStackTrace();
	       }
	       m.addAttribute("center", "mypage/mypage_center");
	       return "index";
	    }
  

   @RequestMapping("/custdetail")
   public String custdetail(Model m, CustVO cust) {
      m.addAttribute("center", "mypage/custdetail");
      return "index";
   }
   
   @RequestMapping("/update")
   public String update(Model m, CustVO cust, HttpSession session) {
      try {         
         CustVO cu = (CustVO) session.getAttribute("user");
         cust.setBirth(cu.getBirth());
         cust.setPoint(cu.getPoint());
         cust.setSex(cu.getSex());
        cust.setPwd(cu.getPwd());
         custbiz.modify(cust);
         CustVO c = custbiz.get(cust.getId());
         session.setAttribute("user", c);         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "redirect:custdetail?id="+cust.getId();
   }
   
   @RequestMapping("/custpwd")
   public String custpwd(Model m, String id) {
	    m.addAttribute("center", "mypage/custpwd");
	      return "index";
   }
   
   @RequestMapping("/custpwdimpl")
   public String custpwdimpl(Model m, String new_pwd, HttpSession session) {
	   CustVO cust = (CustVO) session.getAttribute("user");
	   cust.setPwd(new_pwd);
	   try {
		custbiz.modify(cust);
		session.setAttribute("user", cust);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   m.addAttribute("center", "mypage/mypage_center");
	      return "index";
   }

   @RequestMapping("/custdelete")
      public String custdelete(Model m, HttpSession session) {
      m.addAttribute("center", "mypage/custdelete");
         return "index";
   }
   
   @RequestMapping("/custdeleteimpl")
      public String custdeleteimpl(Model m, String now_pwd, HttpSession session) {
      CustVO cust = (CustVO) session.getAttribute("user");
      
      if(!cust.getPwd().equals(now_pwd)) {
         System.out.println("비밀번호가 다릅니다.");      
      }else {
         System.out.println("해당 id가 삭제되었습니다: " + cust);
         try {
            session.removeAttribute("user");
            custbiz.updateremove(cust.getId());
         }catch (Exception e) {
            e.printStackTrace();
         }      
      }
      m.addAttribute("center", "mypage/custbye");
      return "index";
   }
   
   
   @RequestMapping("/myreservationlist")
   public String myreservationlist(Model m, HttpSession session) {
      List<ReservationVO> list = null;
      CustVO cust = (CustVO) session.getAttribute("user");
      try {
         list = rbiz.selectcust(cust.getId());
         m.addAttribute("reservationlist", list);      
      } catch (Exception e) {
         e.printStackTrace();
      }
      m.addAttribute("center", "mypage/myreservationlist");
      return "index";
   }

   @RequestMapping("/mypointlist")
   public String mypointlist(Model m, HttpSession session) {   
      List<PointlistVO> list = null;
      CustVO cust = (CustVO) session.getAttribute("user");   
      try {
         list = pbiz.selectpoint(cust.getId());
         m.addAttribute("pointlist", list);
      } catch (Exception e) {
         e.printStackTrace();
      }
      m.addAttribute("center", "mypage/mypointlist");
      return "index";
   }
   
   @RequestMapping("/mycouponlist")
   public String mycouponlist(Model m, HttpSession session) {
      List<MycouponVO> list = null;
      CustVO cust = (CustVO) session.getAttribute("user");
      try {
         list = cbiz.selectmycoupon(cust.getId());
         m.addAttribute("mycouponlist", list);
      } catch (Exception e) {
         e.printStackTrace();
      }
      m.addAttribute("center", "mypage/mycouponlist");
      return "index";
   }
}