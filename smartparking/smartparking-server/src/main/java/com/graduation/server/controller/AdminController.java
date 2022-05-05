package com.graduation.server.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.graduation.server.pojo.*;
import com.graduation.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Api(tags = "AdminController")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "获取所有管理员信息")
    @GetMapping("/")
    public List<Admin> getAllAdmins(){
        List<Admin> list = adminService.list();
        List<Admin> resultList = new ArrayList<Admin>();
        Iterator<Admin> iter = list.iterator();
        while (iter.hasNext()){
            Admin admin = (Admin) iter.next();
            admin.setAdminPassword("!!!Encrypted Data!!!");
            resultList.add(admin);
        }
        return resultList;
    }

    @ApiOperation(value = "新增管理员")
    @PostMapping("/addadmin")
    public RespBean addAdmin(@RequestBody AdminInfo adminInfo){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nowtime = LocalDateTime.now();
        String localTime = df.format(nowtime);
        LocalDateTime ldt = LocalDateTime.parse(localTime,df);
        adminInfo.setAdminLatestlogin(ldt);

        try {
            int i = adminService.addAdmin(adminInfo);
            if(i != 0){
                return RespBean.success("新增成功！");
            }
            return RespBean.error("新增失败！");
        }catch (Exception e){
            return RespBean.error("异常错误，请检查数据库中该ID是否已经存在！");
        }
    }

    @ApiOperation(value = "删除管理员")
    @DeleteMapping("/deleteadmin/{id}")
    public RespBean deleteAdmin(@PathVariable String id){
        if (adminService.deleteAdmin(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "修改管理员信息")
    @PutMapping("/updateadmin")
    public RespBean updateAdmin(@RequestBody AdminInfo adminInfo){
        try {
            int i = adminService.updateAdmin(adminInfo);
            if(i != 0){
                return RespBean.success("修改成功！");
            }
            return RespBean.error("修改失败！");
        }catch (Exception e){
            return RespBean.error("异常错误！",e);
        }
    }

    @ApiOperation(value = "修改管理员密码")
    @PutMapping("/changenewpass")
    public RespBean changeNewPassword(@RequestBody AdminInfo adminInfo){
        if (adminService.changeNewPassword(adminInfo)){
            return RespBean.success("密码修改成功！");
        }
        return RespBean.error("密码修改失败！");
    }

    @ApiOperation(value = "根据ID和密码验证密码是否正确")
    @PutMapping("/judgepassword")
    public RespBean judgePassword(@RequestBody AdminInfo adminInfo){
        if (adminService.judgePassword(adminInfo)){
            return RespBean.success("验证成功！");
        }
        return RespBean.error("验证失败！");
    }


    @ApiOperation(value = "根据管理员ID查询管理员信息")
    @GetMapping("/getadmininfobyid/{adminid}")
    public List<AdminInfo> getAdminInfoById(@PathVariable String adminid){
        List<AdminInfo> list = new ArrayList<>();
        AdminInfo adminInfo = adminService.getAdminInfoById(adminid);
        list.add(adminInfo);
        return list;
    }

    @ApiOperation(value = "根据管理员姓名查询管理员信息")
    @GetMapping("/getadmininfobyname/{adminname}")
    public List<AdminInfo> getAdminInfoByName(@PathVariable String adminname){
        return adminService.getAdminInfoByName(adminname);
    }

    @ApiOperation(value = "根据停车场ID查询管理员信息")
    @GetMapping("/getadmininfobyorg/{orgid}")
    public List<AdminInfo> getAdminInfoByOrg(@PathVariable int orgid){
        return adminService.getAdminInfoByOrg(orgid);
    }

}
