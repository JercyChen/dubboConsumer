package com.cn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	//private final Logger logger=LoggerFactory.getLogger(MyInterceptor.class); 
	private static Logger logger = Logger.getLogger(MyInterceptor.class);  
	// 方法执行前
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("方法执行前-------------");
		String contextPath=request.getContextPath();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        //这里可以根据session的用户来判断角色的权限，根据权限来重定向不同的页面，简单起见，这里只是做了一个重定向
        if (StringUtils.isEmpty(user)) {
            //被拦截，重定向到login界面
            response.sendRedirect(contextPath+"/index.jsp");
            return false;
        }
        return true;
	}

	// 方法执行后
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// 视图渲染后
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
