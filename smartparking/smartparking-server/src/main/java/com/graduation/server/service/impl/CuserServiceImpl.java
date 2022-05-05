package com.graduation.server.service.impl;

import com.graduation.server.pojo.Cuser;
import com.graduation.server.mapper.CuserMapper;
import com.graduation.server.service.ICuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Service
public class CuserServiceImpl extends ServiceImpl<CuserMapper, Cuser> implements ICuserService {

    @Autowired
    private CuserMapper cuserMapper;

    /**
     * 根据用户id查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/

    @Override
    public List<Cuser> getCuserById(String id) {
        return cuserMapper.getCuserById(id);
    }

    /**
     * 根据用户姓名查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param name
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/
    @Override
    public List<Cuser> getCuserByName(String name) {
        return cuserMapper.getCuserByName(name);
    }

    /**
     * 根据用户电话查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param phone
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/

    @Override
    public List<Cuser> getCuserByPhone(String phone) {
        return cuserMapper.getCuserByPhone(phone);
    }

    /**
     * 根据id注销用户
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return boolean
     **/
    @Override
    public boolean deleteCuser(String id) {
        return cuserMapper.deleteCuser(id);
    }


    /**
     * 根据车牌号查询用户信息
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param carnumber
     * @return java.util.List<com.graduation.server.pojo.Cuser>
     **/
    @Override
    public Cuser getCuserByCarNumber(String carnumber) {
        return cuserMapper.getCuserByCarNumber(carnumber);
    }



    /**
     * 根据车牌号修改账户余额
     *
     * @author travis-wei
     * @createTime 2022/3/29
     * @param carnumber
     * @param balance
     * @return int
     **/

    @Override
    public int updateBalance(String carnumber, double balance) {
        return cuserMapper.updateBalance(carnumber,balance);
    }


    /**
     * 根据ID和密码验证密码是否正确
     *
     * @author travis-wei
     * @createTime 2022/4/4
     * @param cuser
     * @return boolean
     **/

    @Override
    public boolean judgePassword(Cuser cuser) {
        List<Cuser> list = getCuserById(cuser.getCuserId());
        if (list == null || list.size() == 0){
            return false;
        }
        String oldpassword = "";
        Iterator<Cuser> it = list.iterator();
        while (it.hasNext()) {
            Cuser oldcuser = it.next();
            oldpassword = oldcuser.getCuserPassword();
        }
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(cuser.getCuserPassword(), oldpassword);
        return matches;
    }

    /**
     * 用户余额充值
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    @Override
    public boolean rechargeCuser(Cuser cuser) {
        String cuserid = cuser.getCuserId();
        double chargenumber = cuser.getCuserBalance();
        return cuserMapper.rechargeCuser(cuserid, chargenumber) > 0;
    }

    /**
     * 用户信息修改
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    @Override
    public boolean updateInfoById(Cuser cuser) {
        String cuserId = cuser.getCuserId();

        String cuserName = cuser.getCuserName();
        String cuserPhone = cuser.getCuserPhone();
        int cuserOrgid = cuser.getCuserOrgid();
        String cuserEmail = cuser.getCuserEmail();
        String cuserCarnumber = cuser.getCuserCarnumber();

        return cuserMapper.updateInfoById(cuserId,cuserName,cuserPhone,cuserOrgid,cuserEmail,cuserCarnumber) > 0;
    }

    /**
     * 修改用户密码
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param cuser
     * @return boolean
     **/

    @Override
    public boolean changeNewPassword(Cuser cuser) {
        String cuserid = cuser.getCuserId();
        String password = cuser.getCuserPassword();
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String newpassword = passwordEncoder.encode(password);
        return cuserMapper.changeNewPassword(cuserid, newpassword) > 0;
    }
}
