package com.graduation.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * description: ()
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/3/24 16:52]
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminInfo对象",description = "")
public class AdminInfo {
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
}
