package com.chenxin.cqcvc_dorm.config;

import com.chenxin.cqcvc_dorm.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addInterceptor 注册拦截器
        //addPathPatterns 表示拦截的控制器
        //excludePathPatterns表示排除的控制器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/cqcvc_dorm/**").excludePathPatterns("/cqcvc_dorm/admin/login")
                                                                                    .excludePathPatterns("/cqcvc_dorm/admin/upload/*");
    }
}
