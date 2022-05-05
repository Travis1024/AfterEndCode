package com.graduation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * description: (BCrypt加密工具类)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/28 11:08]
 */

public class BcryptEncoding {
    public static void main(String[] args) {
        //用户密码
        String password = "password6012";
        //密码加密
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //加密
        String newPassword = passwordEncoder.encode(password);
        System.out.println("加密密码为："+newPassword);
        //对比这两个密码是否是同一个密码
        boolean matches = passwordEncoder.matches(password, newPassword);
        System.out.println("两个密码一致:"+matches);
    }

}
