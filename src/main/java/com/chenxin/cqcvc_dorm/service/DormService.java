package com.chenxin.cqcvc_dorm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.entity.DormEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:30:03
 */
public interface DormService extends IService<DormEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<DormEntity> getlistByDbId(Integer id);

    List<DormEntity> getDormByFloor(Integer dormBuildId,Integer floor);

    List<DormEntity> getDormByHouNum(Integer dormBuildId,Integer hounum);
}

