package com.graduation.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * description: (用户登陆实体类)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/25 15:55]
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLogin对象",description = "")
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String userid;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
