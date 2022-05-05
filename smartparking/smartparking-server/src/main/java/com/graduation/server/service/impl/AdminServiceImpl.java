package com.graduation.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.server.config.security.JwtTokenUtils;
import com.graduation.server.pojo.*;
import com.graduation.server.mapper.AdminMapper;
import com.graduation.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录之后返回token
     *
     * @param userid
     * @param password
     * @param request
     * @return com.graduation.server.pojo.RespBean
     * @author travis-wei
     * @createTime 2022/1/25
     **/

    @Override
    public RespBean login(String userid, String password, HttpServletRequest request) {
        //登陆
        UserDetails userDetails = userDetailsService.loadUserByUsername(userid);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确!");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                , null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //生成token
        String token = jwtTokenUtils.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登陆成功!", tokenMap);
    }

    /**
     * 根据用户id获取用户信息
     * 
     * @author travis-wei
     * @createTime 2022/1/25
     * @param userid	
     * @return com.graduation.server.pojo.Admin
     **/
    
    @Override
    public Admin getAdminByUserId(String userid) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("admin_id",userid));
    }


    /**
     * 新增管理员
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param adminInfo
     * @return com.graduation.server.pojo.RespBean
     **/

    @Override
    public int addAdmin(AdminInfo adminInfo) {
        String id = adminInfo.getAdminId();

        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(adminInfo.getAdminPassword());

        String name = adminInfo.getAdminName();
        String phone = adminInfo.getAdminPhone();
        Integer orgid = adminInfo.getAdminOrgid();
        return adminMapper.addAdmin(id,password,name,phone,orgid);
    }


    /**
     * 根据管理员id删除管理员
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param id
     * @return boolean
     **/

    @Override
    public boolean deleteAdmin(String id) {
        return adminMapper.deleteAdmin(id);
    }


    @Override
    public int updateAdmin(AdminInfo adminInfo) {
        String id = adminInfo.getAdminId();
        String name = adminInfo.getAdminName();
        String phone = adminInfo.getAdminPhone();
        Integer orgid = adminInfo.getAdminOrgid();
        return adminMapper.updateAdmin(id,name,phone,orgid);
    }


    /**
     * 根据用户id获取用户信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminid
     * @return com.graduation.server.pojo.AdminInfo
     **/

    @Override
    public AdminInfo getAdminInfoById(String adminid){
        Admin admin = adminMapper.getAdminInfoById(adminid);
        AdminInfo adminInfo = new AdminInfo();

        adminInfo.setAdminId(admin.getAdminId());
        adminInfo.setAdminName(admin.getAdminName());
        adminInfo.setAdminPassword("!!!Encrypted Data!!!");
        adminInfo.setAdminOrgid(admin.getAdminOrgid());
        adminInfo.setAdminPhone(admin.getAdminPhone());
        adminInfo.setAdminLatestlogin(admin.getAdminLatestlogin());

        return adminInfo;
    }

    private AdminInfo getAdminInfoPrivate(String adminid){
        Admin admin = adminMapper.getAdminInfoById(adminid);
        AdminInfo adminInfo = new AdminInfo();

        adminInfo.setAdminId(admin.getAdminId());
        adminInfo.setAdminName(admin.getAdminName());
        adminInfo.setAdminPassword(admin.getAdminPassword());
        adminInfo.setAdminOrgid(admin.getAdminOrgid());
        adminInfo.setAdminPhone(admin.getAdminPhone());
        adminInfo.setAdminLatestlogin(admin.getAdminLatestlogin());

        return adminInfo;
    }

    /**
     * 根据ID和密码验证密码是否正确
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminInfo
     * @return boolean
     **/
    @Override
    public boolean judgePassword(AdminInfo adminInfo) {
        AdminInfo sqladmininfo = getAdminInfoPrivate(adminInfo.getAdminId());

        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(adminInfo.getAdminPassword(), sqladmininfo.getAdminPassword());

        return matches;
    }

    /**
     * 根据管理员姓名查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminname
     * @return com.graduation.server.pojo.AdminInfo
     **/

    @Override
    public List<AdminInfo> getAdminInfoByName(String adminname) {
        List<Admin> adminlist = adminMapper.getAdminInfoByName(adminname);

        List<AdminInfo> adminInfoList = new ArrayList<>();
        Iterator<Admin> it = adminlist.iterator();


        while (it.hasNext()) {
            AdminInfo adminInfo = new AdminInfo();
            Admin admin = it.next();

            adminInfo.setAdminId(admin.getAdminId());
            adminInfo.setAdminName(admin.getAdminName());
            adminInfo.setAdminPassword("!!!Encrypted Data!!!");
            adminInfo.setAdminOrgid(admin.getAdminOrgid());
            adminInfo.setAdminPhone(admin.getAdminPhone());
            adminInfo.setAdminLatestlogin(admin.getAdminLatestlogin());

            adminInfoList.add(adminInfo);
        }

        return adminInfoList;
    }

    /**
     * 根据停车场ID查询管理员信息
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param orgid
     * @return com.graduation.server.pojo.AdminInfo
     **/

    @Override
    public List<AdminInfo> getAdminInfoByOrg(int orgid) {
        List<Admin> adminlist = adminMapper.getAdminInfoByOrg(orgid);

        List<AdminInfo> adminInfoList = new ArrayList<>();
        Iterator<Admin> it = adminlist.iterator();

        while (it.hasNext()) {
            AdminInfo adminInfo = new AdminInfo();
            Admin admin = it.next();

            adminInfo.setAdminId(admin.getAdminId());
            adminInfo.setAdminName(admin.getAdminName());
            adminInfo.setAdminPassword("!!!Encrypted Data!!!");
            adminInfo.setAdminOrgid(admin.getAdminOrgid());
            adminInfo.setAdminPhone(admin.getAdminPhone());
            adminInfo.setAdminLatestlogin(admin.getAdminLatestlogin());

            adminInfoList.add(adminInfo);
        }

        return adminInfoList;
    }

    /**
     * 修改管理员密码
     *
     * @author travis-wei
     * @createTime 2022/4/8
     * @param adminInfo
     * @return boolean
     **/

    @Override
    public boolean changeNewPassword(AdminInfo adminInfo) {
        String adminid = adminInfo.getAdminId();
        String password = adminInfo.getAdminPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newpassword = passwordEncoder.encode(password);
        return adminMapper.changeNewPassword(adminid, newpassword) > 0;
    }

}
