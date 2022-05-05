package com.graduation.server.controller;

import com.graduation.server.pojo.Admin;
import com.graduation.server.pojo.AdminLoginParam;
import com.graduation.server.pojo.RespBean;
import com.graduation.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * description: ()
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/25 16:01]
 */

@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登陆之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUserid(),adminLoginParam.getPassword(),request);
    }

    @ApiOperation(value = "获取当前登陆用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(null==principal){
            return null;
        }
        String userid = principal.getName();
        Admin admin = adminService.getAdminByUserId(userid);
        admin.setAdminPassword(null);
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }
}

