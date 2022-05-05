package com.graduation.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("t_orderlist")
@ApiModel(value="Orderlist对象", description="")
public class Orderlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录单id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "记录单中车牌号码")
    private String orderCarnumber;

    @ApiModelProperty(value = "记录单中车牌颜色")
    private String orderCarnumbercolor;

    @ApiModelProperty(value = "记录单中车辆类型")
    private String orderCartype;

    @ApiModelProperty(value = "记录此单是否为常驻用户")
    private Integer orderJudgecuser;

    @ApiModelProperty(value = "记录此单的停车场id")
    private Integer orderOrgid;

    @ApiModelProperty(value = "记录车辆进入停车场时间")
    private LocalDateTime orderEntrytime;

    @ApiModelProperty(value = "记录车辆离开停车场时间")
    private LocalDateTime orderLefttime;

    @ApiModelProperty(value = "记录该单花费金额")
    private Double orderCost;

    @ApiModelProperty(value = "进入照片url")
    private String orderInurl;

    @ApiModelProperty(value = "离开照片url")
    private String orderOuturl;

    @ApiModelProperty(value = "需要缴纳的费用")
    private Double orderNeedpay;

}
