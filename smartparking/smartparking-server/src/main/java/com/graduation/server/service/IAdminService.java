package com.graduation.server.service;

import com.graduation.server.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.server.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆之后返回token
     * 
     * @author travis-wei
     * @createTime 2022/1/25
     * @param userid	
     * @param password	
     * @param request	
     * @return com.graduation.server.pojo.RespBean
     **/
    
    RespBean login(String userid, String password, HttpServletRequest request);

    /**
     * 根据用户id获取用户信息
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param userid
     * @return com.graduation.server.pojo.Admin
     **/

    Admin getAdminByUserId(String userid);

    /**
     * 新增管理员
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param adminInfo
     * @return com.graduation.server.pojo.RespBean
     **/
    int addAdmin(AdminInfo adminInfo);

    /**
     * 根据管理员id删除管理员
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param id
     * @return boolean
     **/
    boolean deleteAdmin(String id);

    /**
     * 修改管理员信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param adminInfo
     * @return int
     **/
    int updateAdmin(AdminInfo adminInfo);


    AdminInfo getAdminInfoById(String adminid);

    /**
     * 根据ID和密码验证密码是否正确
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminInfo
     * @return boolean
     **/

    boolean judgePassword(AdminInfo adminInfo);

    /**
     * 根据管理员姓名查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminname
     * @return com.graduation.server.pojo.AdminInfo
     **/

    List<AdminInfo> getAdminInfoByName(String adminname);

    /**
     * 根据停车场ID查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param orgid
     * @return com.graduation.server.pojo.AdminInfo
     **/

    List<AdminInfo> getAdminInfoByOrg(int orgid);

    /**
     * 修改管理员密码
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminInfo
     * @return boolean
     **/

    boolean changeNewPassword(AdminInfo adminInfo);
}
