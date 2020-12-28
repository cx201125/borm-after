package com.chenxin.cqcvc_dorm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chenxin.cqcvc_dorm.entity.DormEntity;
import com.chenxin.cqcvc_dorm.service.DormService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.R;



/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:30:03
 */
@RestController
@RequestMapping("cqcvc_dorm/dorm")
public class DormController {
    @Autowired
    private DormService dormService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dormService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据楼层查询的列表
     */
    @RequestMapping("/floor")
    public R floor(@RequestParam("dormBuildId") Integer dormBuildId,@RequestParam("floor") Integer floor){
        List<DormEntity> list = dormService.getDormByFloor(dormBuildId,floor);

        return R.ok().put("list", list);
    }

    /**
     * 根据门牌号查询宿舍
     */
    @RequestMapping("/hounum")
    public R hounum(@RequestParam("dormBuildId") Integer dormBuildId,@RequestParam("hounum")Integer hounum){
        List<DormEntity> list = dormService.getDormByHouNum(dormBuildId,hounum);

        return R.ok().put("list", list);
    }
    /**
     * 根据宿舍楼获取列表
     */
    @RequestMapping("/list/{id}")
    public R listByDbId(@PathVariable("id") Integer id){

       List<DormEntity> list= dormService.getlistByDbId(id);

        return R.ok().put("list", list);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{dormId}")
    public R info(@PathVariable("dormId") Long dormId){
		DormEntity dorm = dormService.getById(dormId);

        return R.ok().put("dorm", dorm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DormEntity dorm){
		dormService.save(dorm);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DormEntity dorm){
		dormService.updateById(dorm);

        return R.ok();
    }

    /**
     * 更新或者修改根据有无id判断
     */
    @RequestMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody DormEntity dorm){
        dormService.saveOrUpdate(dorm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] dormIds){
		dormService.removeByIds(Arrays.asList(dormIds));

        return R.ok();
    }

}
