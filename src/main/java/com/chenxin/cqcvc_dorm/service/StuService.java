package com.chenxin.cqcvc_dorm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.entity.StuEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:56:27
 */
public interface StuService extends IService<StuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<StuEntity> getListByDormId(Integer dormId);
}

