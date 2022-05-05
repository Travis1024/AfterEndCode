package com.graduation.server.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("t_cuser")
@ApiModel(value="Cuser对象", description="")
public class Cuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "常驻用户id")
    @TableId
    private String cuserId;

    @ApiModelProperty(value = "常驻用户密码")
    private String cuserPassword;

    @ApiModelProperty(value = "常驻用户姓名")
    private String cuserName;

    @ApiModelProperty(value = "常驻用户手机号码")
    private String cuserPhone;

    @ApiModelProperty(value = "常驻用户所属停车场id")
    private Integer cuserOrgid;

    @ApiModelProperty(value = "常驻用户邮箱")
    private String cuserEmail;

    @ApiModelProperty(value = "常驻用户车牌号码")
    private String cuserCarnumber;

    @ApiModelProperty(value = "常驻用户余额")
    private double cuserBalance;


}
