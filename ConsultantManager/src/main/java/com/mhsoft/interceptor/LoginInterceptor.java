package com.mhsoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mhsoft.attr.LoginAttribute;
import com.mhsoft.vo.MemberVO;

@Component
public class LoginInterceptor implements HandlerInterceptor{
 
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//클라이언트 요청을 컨트롤러에 전달하기 전에 호출됨
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        MemberVO loginVO = (MemberVO) session.getAttribute(LoginAttribute.ATTR_LOGIN_ID);
        
        if(ObjectUtils.isEmpty(loginVO))
        {
        	logger.info("[MHLI0001]Login is Empty");
            response.sendRedirect("/admin/login");
            return false;
        }
        else
        {
        	logger.info("[MHLI0002]Login is not empty");
            //session.setMaxInactiveInterval(30*60);
            return true;
        }
        
    }
    //클라이언트의 요청을 처리한 뒤에 호출됨
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        
    }
 
    //클라이언트 요청을 마치고 뷰를 통해 응답 전송뒤 실행됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        
    }
 
}
