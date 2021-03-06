package com.mhsoft.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mhsoft.service.MemberService;

@RestController
public class CMController {
	
	private static final Logger logger = LoggerFactory.getLogger(CMController.class);

	@Autowired
	MemberService m_service;
	
	@RequestMapping("/")
	public ModelAndView main(HttpServletRequest req) 
	{
		HttpSession session = req.getSession();
		ModelAndView view = new ModelAndView();
		if(session.getAttribute("member")==null)
		{
			view.setViewName("redirect:/admin/login");
		}
		else
		{
			view.setViewName("main");
		}
		return view;
	}
	
	@RequestMapping("/server-time")
	public String serverTime() {
		return m_service.getServerTime();
	}
	/**
	 * 로그인 페이지
	 * @return
	 */
	@RequestMapping("/admin/login")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView view = new ModelAndView();
		HttpSession session = req.getSession();
		if(session.getAttribute("member")!=null)
		{
			view.setViewName("redirect:/");
		}
		else
		{
			view.setViewName("admin/login");

		}
		return view;
	}
	
	@RequestMapping("/admin/logout.do")
	public ModelAndView logoutDo(HttpServletRequest req, RedirectAttributes redirect)
	{
		ModelAndView view = new ModelAndView();
		HttpSession session = req.getSession();
		session.removeAttribute("member");
		view.setViewName("redirect:/admin/login");
		return view;
	}
	
	@RequestMapping("/admin/login.do")
	public ModelAndView loginDo(@RequestParam(value="m_id", required=false, defaultValue="") String id,
								@RequestParam(value="m_pw", required=false, defaultValue="") String pw,
								HttpServletRequest req, RedirectAttributes redirect) 
	{
		List<Map<String, String>> result = m_service.doLogin(id, pw);
		ModelAndView view = new ModelAndView();
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(1800);
		
		if(session.getAttribute("member")!=null)
		{
			session.setAttribute("member", result.get(0).get("m_name"));
			logger.info("ID:" + result.get(0).get("m_id"));
			view.setViewName("redirect:/");
		}
		else if(result!=null && result.size()!=0)
		{
			session.setAttribute("member", result.get(0).get("m_name"));
			logger.info("ID:" + result.get(0).get("m_id"));
			view.setViewName("redirect:/");
		}
		else
		{
			view.setViewName("redirect:/admin/invalid");
		}
		return view;
	}
	
	
	
	@RequestMapping("/admin/invalid")
	public ModelAndView error() 
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/invalid");
		return view;
	}
}
