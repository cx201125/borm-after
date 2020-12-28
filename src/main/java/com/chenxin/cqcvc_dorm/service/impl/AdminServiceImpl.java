package com.chenxin.cqcvc_dorm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenxin.cqcvc_dorm.exception.NotFountException;
import com.chenxin.cqcvc_dorm.utils.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.Query;

import com.chenxin.cqcvc_dorm.dao.AdminDao;
import com.chenxin.cqcvc_dorm.entity.AdminEntity;
import com.chenxin.cqcvc_dorm.service.AdminService;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {
     @Autowired
     private AdminDao adminDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                new QueryWrapper<AdminEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public AdminEntity querylogin(AdminEntity adminEntity) {
        QueryWrapper<AdminEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",adminEntity.getUsername());
        AdminEntity adminEntity1 = adminDao.selectOne(wrapper);
        if(adminEntity1==null){
            throw new NotFountException("输入的账户不存在", 400);
        }

       if(!adminEntity1.getPassword().equals(adminEntity.getPassword())){
           throw new NotFountException("输入的密码错误", 400);
       }

        return adminEntity1;
    }

    @Override
    public void updateHeadPortrait(Integer adminId,String strUrl) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdminId(adminId);
        adminEntity.setHeadPortrait(strUrl);
        adminDao.updateById(adminEntity);
    }

}