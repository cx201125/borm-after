package com.chenxin.cqcvc_dorm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.entity.DormBuildEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-22 19:45:30
 */
public interface DormBuildService extends IService<DormBuildEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

