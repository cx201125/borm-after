package com.chenxin.cqcvc_dorm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatisPlus的配置文件
 */
@Configuration
@MapperScan("com.chenxin.cqcvc_dorm.dao")
public class MybatisPlusConfig {
}
