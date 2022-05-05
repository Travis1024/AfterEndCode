package com.graduation.server.service;

import com.graduation.server.pojo.Cuser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface ICuserService extends IService<Cuser> {
    /**
     * 根据用户id查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/
    List<Cuser> getCuserById(String id);


    /**
     * 根据用户姓名查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param name
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/
    List<Cuser> getCuserByName(String name);

    /**
     * 根据用户电话查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param phone
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/
    List<Cuser> getCuserByPhone(String phone);

    /**
     * 根据id注销用户
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return boolean
     **/
    boolean deleteCuser(String id);

    /**
     * 根据车牌号查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param carnumber
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/

    Cuser getCuserByCarNumber(String carnumber);


    int updateBalance(String carnumber, double balance);

    /**
     * 根据ID和密码验证密码是否正确
     *
     * @author travis-wei
     * @createTime 2022/4/4
     * @param cuser
     * @return boolean
     **/

    boolean judgePassword(Cuser cuser);

    /**
     * 用户余额充值
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    boolean rechargeCuser(Cuser cuser);


    /**
     * 用户信息修改
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    boolean updateInfoById(Cuser cuser);


    /**
     * 修改用户密码
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    boolean changeNewPassword(Cuser cuser);
}
