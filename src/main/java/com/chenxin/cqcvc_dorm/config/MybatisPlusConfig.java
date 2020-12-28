package com.chenxin.cqcvc_dorm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.chenxin.cqcvc_dorm.dao")
public class MybatisPlusConfig {
}
