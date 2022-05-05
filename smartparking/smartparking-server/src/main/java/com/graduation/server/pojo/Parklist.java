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
@TableName("t_parklist")
@ApiModel(value="Parklist对象", description="")
public class Parklist implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "停车场id")
    @TableId
    private Integer orgId;

    @ApiModelProperty(value = "停车场名称")
    private String orgName;

    @ApiModelProperty(value = "停车场车位总数量")
    private Integer orgTotalnumber;

    @ApiModelProperty(value = "停车场被占用车位数量")
    private Integer orgBusynumber;

    @ApiModelProperty(value = "停车场地址")
    private String orgAddress;

    @ApiModelProperty(value = "停车场管理员姓名")
    private String orgManagername;

    @ApiModelProperty(value = "停车场管理员手机号码")
    private String orgManagerphone;

    @ApiModelProperty(value = "停车场状态")
    private String orgStatus;

    @ApiModelProperty(value = "停车场管理密码")
    private String orgUnlockpassword;

    @ApiModelProperty(value = "停车场计费规则id")
    private Integer orgPriceid;


}
