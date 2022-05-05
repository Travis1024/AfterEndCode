package com.graduation.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * description: ()
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/3/24 21:31]
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PasswordInfo对象",description = "")
public class PasswordInfo {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "旧密码")
    private String oldPassword;

    @ApiModelProperty(value = "新密码")
    private String newPassword;
}
