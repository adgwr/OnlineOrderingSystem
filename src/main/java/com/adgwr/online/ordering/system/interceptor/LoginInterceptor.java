package com.adgwr.online.ordering.system.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * 拦截器
 * @author Administrator
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final String APP_PATH="http://localhost";

    private static final List<String> URL_LIST_WITH_PARA= Arrays.asList(
            APP_PATH+"/login",
            APP_PATH+"/getFoods",
            APP_PATH+"/foodDetail"
    );

    private static final List<String> URL_LIST_WITHOUT_PARA= Arrays.asList(
            APP_PATH+"/pcHomepage",
            APP_PATH+"/menu",
            APP_PATH+"/register",
            APP_PATH+"/");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getRequestURL().toString();
        Object customer = session.getAttribute("customer");
        Object adminAccount = session.getAttribute("adminAccount");
        if(customer==null && adminAccount==null){
            if(URL_LIST_WITH_PARA.contains(url) && request.getParameterNames().hasMoreElements()
        || URL_LIST_WITHOUT_PARA.contains(url)){
                return true;
            }else{
                response.sendRedirect("/pcHomepage");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
