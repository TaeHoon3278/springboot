package com.mhsoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mhsoft.service.MemberService;

@RestController
public class CMController {

	@Autowired
	MemberService m_service;
	
	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView view = new ModelAndView();
		view.setViewName("test");
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
	public ModelAndView login() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/login");
		return view;
	}
	
	@RequestMapping("/admin/login.do")
	public ModelAndView loginDo(@RequestParam("m_id") String id,
								@RequestParam("m_pw") String pw) 
	{
		System.out.println("+++++++++++++ID:" + id + "/" + "PW:" + pw);
		boolean bResult = m_service.doLogin(id, pw);
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/login");
		return view;
	}
}
