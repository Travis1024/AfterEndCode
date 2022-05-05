package com.graduation.server.mapper;

import com.graduation.server.pojo.Cuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Cuser;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface CuserMapper extends BaseMapper<Cuser> {

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

    /**
     * 根据车牌号修改账户余额
     *
     * @author travis-wei
     * @createTime 2022/3/29
     * @param carnumber
     * @param balance
     * @return int
     **/

    int updateBalance(String carnumber, double balance);

    /**
     * 用户余额充值
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuserid
     * @param chargenumber
     * @return int
     **/
    int rechargeCuser(String cuserid, double chargenumber);

    /**
     * 修改用户信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuserId
     * @param cuserName
     * @param cuserPhone
     * @param cuserOrgid
     * @param cuserEmail
     * @param cuserCarnumber
     * @return int
     **/

    int updateInfoById(String cuserId, String cuserName, String cuserPhone, int cuserOrgid, String cuserEmail, String cuserCarnumber);

    /**
     * 修改用户密码
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuserid
     * @param newpassword
     * @return int
     **/

    int changeNewPassword(String cuserid, String newpassword);
}
