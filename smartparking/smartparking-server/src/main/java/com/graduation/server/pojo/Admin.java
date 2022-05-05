package com.graduation.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_admin")
@ApiModel(value="Admin对象", description="")
public class Admin implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "管理员登陆id")
    private String adminId;

    @ApiModelProperty(value = "管理员登陆密码")
    private String adminPassword;

    @ApiModelProperty(value = "最近登陆时间")
    private LocalDateTime adminLatestlogin;

    @ApiModelProperty(value = "管理员姓名")
    private String adminName;

    @ApiModelProperty(value = "管理员手机号")
    private String adminPhone;

    @ApiModelProperty(value = "管理员所管理的停车场id")
    private Integer adminOrgid;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return adminPassword;
    }

    @Override
    public String getUsername() {
        return adminId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
