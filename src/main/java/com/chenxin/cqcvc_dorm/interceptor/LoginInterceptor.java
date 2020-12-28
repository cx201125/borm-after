package com.chenxin.cqcvc_dorm.interceptor;

import com.chenxin.cqcvc_dorm.exception.NotFountException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
/**
 * 登录校验拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //这个是访问控制器之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //前端的token
        String token = request.getHeader("token");
        HttpSession session = request.getSession();
        String stoken = (String) session.getAttribute("stoken");
//        log.error("====token======"+token);
//        log.error("=======stoken==="+stoken);
        if(StringUtils.isEmpty(token)||StringUtils.isEmpty(stoken)){
            log.error("没有找到token");
            throw new NotFountException("你未登录或者登录已经过期", 401);
        }else if(!token.equals(stoken)){
            log.error("请求头的token和session的cookie不一致");
            throw new NotFountException("你未登录或者登录已经过期", 401);
        }else{
            return true;
        }
    }
    //这个是访问控制器之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //这个是最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
