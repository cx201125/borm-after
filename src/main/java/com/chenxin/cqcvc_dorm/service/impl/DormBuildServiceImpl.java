package com.chenxin.cqcvc_dorm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.Query;

import com.chenxin.cqcvc_dorm.dao.DormBuildDao;
import com.chenxin.cqcvc_dorm.entity.DormBuildEntity;
import com.chenxin.cqcvc_dorm.service.DormBuildService;


@Service("dormBuildService")
public class DormBuildServiceImpl extends ServiceImpl<DormBuildDao, DormBuildEntity> implements DormBuildService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DormBuildEntity> page = this.page(
                new Query<DormBuildEntity>().getPage(params),
                new QueryWrapper<DormBuildEntity>()
        );

        return new PageUtils(page);
    }

}