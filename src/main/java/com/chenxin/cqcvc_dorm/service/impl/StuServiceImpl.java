package com.chenxin.cqcvc_dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.Query;

import com.chenxin.cqcvc_dorm.dao.StuDao;
import com.chenxin.cqcvc_dorm.entity.StuEntity;
import com.chenxin.cqcvc_dorm.service.StuService;


@Service("stuService")
public class StuServiceImpl extends ServiceImpl<StuDao, StuEntity> implements StuService {
    @Autowired
    private StuDao stuDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StuEntity> page = this.page(
                new Query<StuEntity>().getPage(params),
                new QueryWrapper<StuEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 根据宿舍Id获取学生信息
     * @param dormId
     * @return
     */
    @Override
    public List<StuEntity> getListByDormId(Integer dormId) {
        QueryWrapper<StuEntity> sq = new QueryWrapper<>();
        sq.eq("dorm_id",dormId);
        List<StuEntity> stuEntities = stuDao.selectList(sq);
        return stuEntities;
    }

}