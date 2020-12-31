package com.chenxin.cqcvc_dorm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置阿里巴巴Druid数据源的监控平台
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource Druid(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
    //    配置Druid的监控
//    配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> map=new HashMap<>();
        map.put("loginUsername","cx201125");
        map.put("loginPassword","123456");
        bean.setInitParameters(map);
        return bean;
    }
    //    配置一个监控的fifter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> map=new HashMap<>();
        //设置哪些方法不拦截
        map.put("exclusions","*.js,*.css,/druid/*");
        //设置拦截的地址
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.setInitParameters(map);
        return bean;
    }
}

