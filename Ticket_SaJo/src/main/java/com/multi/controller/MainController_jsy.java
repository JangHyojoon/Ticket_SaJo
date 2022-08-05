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
public class MainController_jsy {
   
   @Autowired
   CustBiz custbiz;
   
   @Autowired
   ReservationBiz rbiz;
   
   @Autowired
   PointlistBiz pbiz;
   
   @Autowired
   MycouponBiz cbiz;
   
   @RequestMapping("/signin")
   public String signin(Model m, String msg, HttpServletRequest request) {
      if(msg !=null && msg.equals("f")) {
         m.addAttribute("msg", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
      }
      // ********** 0722 - 안원영 수정 **********
      String uri = request.getHeader("Referer");
//      System.out.println("이전 url : " + uri);
       if (uri != null && !uri.contains("/signinimpl") && !uri.contains("/signin") && !uri.contains("/custdeleteimpl")){// 이전페이지가 있으면 실행 
           request.getSession().setAttribute("prevPage", uri);// session에 prevPage 변수에 이전페이지 url 기억 
       }
      
       // ********** 0722 - 안원영 수정 **********
       
      m.addAttribute("center", "signin");
      return "index";
   }
   
   @RequestMapping("/signout")
   public String signout(Model m, HttpSession session) {
      if(session !=null ) {
         session.invalidate();         
      }
      return "redirect:/";
   }

   @RequestMapping("/signinimpl")
   public String signinimpl(Model m, String id, String pwd, HttpSession session) {
      CustVO cust = null;

      try {
         cust = custbiz.get(id);
         if(cust !=null) {
            if(cust.getPwd().equals(pwd)) {
               session.setAttribute("user",cust);
               m.addAttribute("user", cust);
               // ********** 0722 - 안원영 수정 **********
               if(session.getAttribute("prevPage") != null) {
                  String prevPage;
                  String pageArr[];
                  prevPage = (String) session.getAttribute("prevPage");
                  pageArr = prevPage.split("/",4);// / 4개까지만 나눈다.
                  
//                  System.out.println("signinimpl prevPage : " + session.getAttribute("prevPage"));
//                    for(int i=0 ; i<pageArr.length ; i++)
//                    {
//                       System.out.println("pageArr["+i+"] : " + pageArr[i]);
//                    }

                  return "redirect:/"+pageArr[pageArr.length-1];
               }
               // ********** 0722 - 안원영 수정 **********
               
            }else {
               throw new Exception(); 
            }
            
         }else {
            throw new Exception();
         }
      } catch (Exception e) {   
         return "redirect:signin?msg=f";
      }
      return "redirect:/";     
   }
   
   @RequestMapping("/signup")
   public String signup(Model m) {
      m.addAttribute("center", "signup");
      return "index";
   }
   
   @RequestMapping("/signupimpl")
   public String signupimpl(Model m, CustVO cust, HttpSession session) {
      try {
         System.out.println(cust);
         custbiz.register(cust);
         session.setAttribute("user", cust);
         m.addAttribute("center", "/signupok");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "index";
   }
   
   @RequestMapping("/mypage")
   public String mypage(Model m) {
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/mypage_center");
      m.addAttribute("center", "mypage/mypage");
      return "index";
   }
   
   @RequestMapping("/custdetail")
   public String custdetail(Model m, CustVO cust) {
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/custdetail");
      m.addAttribute("center", "mypage/mypage");
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
	    m.addAttribute("left", "mypage/left");
	    m.addAttribute("mypage_center", "mypage/custpwd");
	    m.addAttribute("center", "mypage/mypage");
	      return "index";
   }
   
   @RequestMapping("/custpwdimpl")
   public String custpwdimpl(Model m, String newpwd, HttpSession session) {
	   CustVO cust = (CustVO) session.getAttribute("user");
	   System.out.println("현재 비밀번호 : " + cust);
	   cust.setPwd(newpwd);
	   try {
		custbiz.modify(cust);
		session.setAttribute("user", cust);
		System.out.println("변경된 비밀번호 : " + cust);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   m.addAttribute("left", "mypage/left");
	   m.addAttribute("mypage_center", "mypage/mypage_center");
	   m.addAttribute("center", "mypage/mypage");
	      return "index";
   }

   @RequestMapping("/custdelete")
      public String custdelete(Model m, HttpSession session) {
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/custdelete");
      m.addAttribute("center", "mypage/mypage");
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
            custbiz.remove(cust.getId());
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
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/myreservationlist");
      m.addAttribute("center", "mypage/mypage");
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
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/mypointlist");
      m.addAttribute("center", "mypage/mypage");
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
      m.addAttribute("left", "mypage/left");
      m.addAttribute("mypage_center", "mypage/mycouponlist");
      m.addAttribute("center", "mypage/mypage");
      return "index";
   }
}