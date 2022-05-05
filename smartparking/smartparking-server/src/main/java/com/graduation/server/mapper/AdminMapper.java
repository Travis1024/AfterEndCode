package com.graduation.server.mapper;

import com.graduation.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Admin;
import com.graduation.server.pojo.AdminInfo;
import com.graduation.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 新增管理员
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param id
     * @param password
     * @param name
     * @param phone
     * @param orgid
     * @return com.graduation.server.pojo.RespBean
     **/
    int addAdmin(String id, String password, String name, String phone, Integer orgid);


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
     * @param id
     * @param name
     * @param phone
     * @param orgid
     * @return int
     **/
    int updateAdmin(String id, String name, String phone, Integer orgid);


    /**
     * 根据用户id获取用户信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminid
     * @return com.graduation.server.pojo.Admin
     **/

    Admin getAdminInfoById(String adminid);

    /**
     * 根据管理员姓名查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminname
     * @return com.graduation.server.pojo.Admin
     **/

    List<Admin> getAdminInfoByName(String adminname);

    /**
     * 根据停车场ID查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param orgid
     * @return com.graduation.server.pojo.Admin
     **/

    List<Admin> getAdminInfoByOrg(int orgid);

    /**
     *
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminid
     * @param newpassword
     * @return int
     **/
    int changeNewPassword(String adminid, String newpassword);
}
