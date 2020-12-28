package com.chenxin.cqcvc_dorm.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import cn.hutool.core.util.IdUtil;
import com.chenxin.cqcvc_dorm.utils.PageUtils;
import com.chenxin.cqcvc_dorm.utils.R;
import com.chenxin.cqcvc_dorm.utils.TokenProccessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chenxin.cqcvc_dorm.entity.AdminEntity;
import com.chenxin.cqcvc_dorm.service.AdminService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 
 *
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:30:03
 */
@RestController
@RequestMapping("cqcvc_dorm/admin")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{adminId}")
    public R info(@PathVariable("adminId") Integer adminId){
		AdminEntity admin = adminService.getById(adminId);

        return R.ok().put("admin", admin);
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public R login(@RequestBody AdminEntity admin, HttpSession session){
        System.out.println(admin);
        AdminEntity data=adminService.querylogin(admin);
        //登录验证成功，返回token
        String token = TokenProccessor.getInstance().makeToken();;
        session.setAttribute("stoken",token);
        return R.ok().put("data",data).put("token",token);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AdminEntity admin){
		adminService.save(admin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AdminEntity admin){
		adminService.updateById(admin);

        return R.ok();
    }

    @RequestMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody AdminEntity admin){
        adminService.saveOrUpdate(admin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] adminIds){
		adminService.removeByIds(Arrays.asList(adminIds));

        return R.ok();
    }

    /**
     * 清除session
     */
    @RequestMapping("/closesession")
    public R closesession(HttpSession session){
        //删除stoken
        session.removeAttribute("stoken");
        return R.ok();
    }

    /**
     * 上传头像
     */
    @RequestMapping("/upload/{adminId}")
    public R upload(MultipartFile file,@PathVariable("adminId") Integer adminId, HttpServletRequest req) throws IOException {


        // 得到上传时的文件名
        System.out.println(adminId);
        //判断文件名不等于null
        if (file == null) {
            return R.error(404,"文件为空");
        }
//        获得文件的后缀
        String originName = file.getOriginalFilename();
        String suffix = originName.substring(originName.lastIndexOf(".") + 1);

//        文件名（用uuid生成的）
        String filename = IdUtil.simpleUUID()+"."+suffix;
        //图片存放地址
        String realPath="F://dormupload/";
        File folder = new File(realPath);
        // 保存文件对象
        file.transferTo(new File(folder, filename));

        //访问图片的url地址
        String strUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()+"/image/"+filename;
        //        把图片的访问地址保存到数据库
        adminService.updateHeadPortrait(adminId,strUrl);

        return R.ok();
    }

}
