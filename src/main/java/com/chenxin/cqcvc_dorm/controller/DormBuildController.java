package com.chenxin.cqcvc_dorm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chenxin.cqcvc_dorm.entity.DormBuildEntity;
import com.chenxin.cqcvc_dorm.service.DormBuildService;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.R;



/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-22 19:45:30
 */
@RestController
@RequestMapping("cqcvc_dorm/dormbuild")
public class DormBuildController {
    @Autowired
    private DormBuildService dormBuildService;

//    /**
//     * 列表（分页）
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = dormBuildService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
    /**
     * 列表(不分页)
     */
    @RequestMapping("/list")
    public R list(){
        List<DormBuildEntity> list = dormBuildService.list();

        return R.ok().put("list", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{dbId}")
    public R info(@PathVariable("dbId") Integer dbId){
		DormBuildEntity dormBuild = dormBuildService.getById(dbId);

        return R.ok().put("dormBuild", dormBuild);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DormBuildEntity dormBuild){
		dormBuildService.save(dormBuild);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DormBuildEntity dormBuild){
		dormBuildService.updateById(dormBuild);

        return R.ok();
    }
    /**
     * 保存或者修改(判断条件是是否携带id)
     */
    @RequestMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody DormBuildEntity dormBuild){
        System.out.println("======="+dormBuild);
        boolean b = dormBuildService.saveOrUpdate(dormBuild);

        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] dbIds){
		dormBuildService.removeByIds(Arrays.asList(dbIds));

        return R.ok();
    }

}
