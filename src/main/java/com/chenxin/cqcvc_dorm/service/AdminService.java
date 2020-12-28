package com.chenxin.cqcvc_dorm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.entity.AdminEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:30:03
 */
public interface AdminService extends IService<AdminEntity> {

    PageUtils queryPage(Map<String, Object> params);

    AdminEntity querylogin(AdminEntity adminEntity);

    void updateHeadPortrait(Integer adminId,String strUrl);
}

