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

import com.mhsoft.attr.LoginAttribute;
import com.mhsoft.service.MemberService;
import com.mhsoft.vo.MemberVO;
import com.mhsoft.attr.LoginAttribute;

@RestController
public class CMController {
	
	private static final Logger logger = LoggerFactory.getLogger(CMController.class);

	@Autowired
	MemberService m_service;
		
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
		if(session.getAttribute(LoginAttribute.ATTR_LOGIN_ID)!=null)
		{
			view.setViewName("redirect:/admin/main");
		}
		else
		{
			view.setViewName("admin/login");

		}
		return view;
	}
	/**
	 * 로그아웃 페이지
	 * @param req
	 * @param redirect
	 * @return
	 */
	@RequestMapping("/admin/logout.do")
	public ModelAndView logoutDo(HttpServletRequest req, RedirectAttributes redirect)
	{
		ModelAndView view = new ModelAndView();
		HttpSession session = req.getSession();
		session.invalidate();
		view.setViewName("redirect:/admin/login");
		return view;
	}
	
	@RequestMapping("/admin/login.do")
	public ModelAndView loginDo(@RequestParam(value="m_id", required=false, defaultValue="") String id,
								@RequestParam(value="m_pw", required=false, defaultValue="") String pw,
								HttpServletRequest req, RedirectAttributes redirect) 
	{
		HttpSession session = req.getSession();
		ModelAndView view = new ModelAndView();
		MemberVO result = m_service.doLogin(id, pw);
		if(null == result)
		{
			logger.info("[MHL0002]Login fail. NULL error");
			view.setViewName("admin/invalid");

			return view;
		}
		else
		{
			logger.info("[MHL0002]Login Success.");
			session.setAttribute(LoginAttribute.ATTR_LOGIN_ID, result);
			session.setMaxInactiveInterval(1800);
			view.setViewName("redirect:/admin/main");

		}
		
		
		
		logger.info("[MHL0000]result-> ID:" + result.getM_id());
		
		return view;
	}
	
	
	/**
	 * 유효하지 않은 페이지
	 * @return
	 */
	@RequestMapping("/admin/invalid")
	public ModelAndView error() 
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/invalid");
		return view;
	}
	
	
	/**
	 * 메인페이지
	 * @return
	 */
	@RequestMapping("/admin/main")
	public ModelAndView main()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
		
	}
	
}
