package com.chenxin.cqcvc_dorm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.Query;

import com.chenxin.cqcvc_dorm.dao.DormDao;
import com.chenxin.cqcvc_dorm.entity.DormEntity;
import com.chenxin.cqcvc_dorm.service.DormService;


@Service("dormService")
public class DormServiceImpl extends ServiceImpl<DormDao, DormEntity> implements DormService {
    @Autowired(required = true)
    private DormDao dormDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DormEntity> page = this.page(
                new Query<DormEntity>().getPage(params),
                new QueryWrapper<DormEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 根据宿舍楼Id查询
     * @param id
     * @return
     */
    @Override
    public List<DormEntity> getlistByDbId(Integer id) {
        QueryWrapper   qw=new QueryWrapper<DormEntity>();
        qw.eq("dorm_build_id",id);
        List<DormEntity> list = dormDao.selectList(qw);
        return list;

    }

    /**
     * 根据楼层查询
     * @param floor
     * @return
     */
    @Override
    public List<DormEntity> getDormByFloor(Integer dormBuildId,Integer floor) {
        QueryWrapper<DormEntity>   qw= new QueryWrapper<>();
        return getDormEntities(dormBuildId, floor, qw, "floor");
    }

    private List<DormEntity> getDormEntities(Integer dormBuildId, Integer floor, QueryWrapper<DormEntity> qw, String floor2) {
        Map<String, Object> map = new HashMap<>();
        map.put("dorm_build_id",dormBuildId);
        map.put(floor2,floor);
        qw.allEq(map);
        List<DormEntity> list = dormDao.selectList(qw);
        return list;
    }

    /**
     * 根据宿舍门牌号查询
     * @param hounum
     * @return
     */
    @Override
    public List<DormEntity> getDormByHouNum(Integer dormBuildId,Integer hounum) {
        QueryWrapper<DormEntity>   qw=new QueryWrapper<>();
        return getDormEntities(dormBuildId, hounum, qw, "hou_num");
    }

}