package com.mall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mall.model.EmUser;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	private String obviateUrl;
	private String backUrl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {
			String url = request.getRequestURI();
			String contextPath = request.getContextPath();
			HttpSession session = request.getSession();
			EmUser user = (EmUser) request.getAttribute(session.getId());
			if (user != null || url.equals(obviateUrl)) {
				return true;
			} else {
				// 转到session失效页面
				String targetUrl = contextPath + backUrl;
				response.sendRedirect(response.encodeRedirectURL(targetUrl));
				return false;
			}

		} else {
			return true;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public String getObviateUrl() {
		return obviateUrl;
	}

	public void setObviateUrl(String obviateUrl) {
		this.obviateUrl = obviateUrl;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

}
