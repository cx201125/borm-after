package com.chenxin.cqcvc_dorm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chenxin.cqcvc_dorm.entity.StuEntity;
import com.chenxin.cqcvc_dorm.service.StuService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.R;



/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-24 22:05:47
 */
@RestController
@RequestMapping("cqcvc_dorm/stu")
public class StuController {
    @Autowired
    private StuService stuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stuService.queryPage(params);

        return R.ok().put("page", page);
    }
	
	/**
     * 列表（根据宿舍的id获取）
     */
    @RequestMapping("/dormstu/{dormId}")
    public R listByDormId(@PathVariable("dormId") Integer dormId){
        List<StuEntity> list = stuService.getListByDormId(dormId);

        return R.ok().put("list", list);
    }
    

    /**
     * 信息
     */
    @RequestMapping("/info/{stuId}")
    public R info(@PathVariable("stuId") Long stuId){
		StuEntity stu = stuService.getById(stuId);

        return R.ok().put("stu", stu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StuEntity stu){
		stuService.save(stu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StuEntity stu){
		stuService.updateById(stu);

        return R.ok();
    }

    /**
     * 保存或者修改
     */
    @RequestMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody StuEntity stu){
        stuService.saveOrUpdate(stu);

        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] stuIds){
		stuService.removeByIds(Arrays.asList(stuIds));

        return R.ok();
    }

}
