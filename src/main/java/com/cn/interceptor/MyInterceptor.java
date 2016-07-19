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
	// ����ִ��ǰ
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("����ִ��ǰ-------------");
		String contextPath=request.getContextPath();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        //������Ը���session���û����жϽ�ɫ��Ȩ�ޣ�����Ȩ�����ض���ͬ��ҳ�棬�����������ֻ������һ���ض���
        if (StringUtils.isEmpty(user)) {
            //�����أ��ض���login����
            response.sendRedirect(contextPath+"/index.jsp");
            return false;
        }
        return true;
	}

	// ����ִ�к�
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// ��ͼ��Ⱦ��
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
