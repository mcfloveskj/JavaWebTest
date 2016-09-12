package com.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

public class SpringMVCInterceptor implements HandlerInterceptor{
	
	private static final String index[] = {"index.do", "login.do", "logout.do"};

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView model) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		String url = request.getRequestURL().toString();
		for (String s : index){
			if (url.contains(s)) {
	            return true;
	        }
		}
		
		String session = (String) WebUtils.getSessionAttribute(request,
				"username");
		if(session != null) {
			return true;
		}else {
			throw new SessionTimeoutException("登录超时");
		}
	}

}
