package com.graduation.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_incar")
@ApiModel(value="Incar对象", description="")
public class Incar implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录表ID号")
    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    @ApiModelProperty(value = "车牌号码")
    private String carNumber;

    @ApiModelProperty(value = "车牌颜色")
    private String carNumbercolor;

    @ApiModelProperty(value = "车辆类型")
    private String carType;

    @ApiModelProperty(value = "该车辆是否是常驻用户车辆")
    private Integer carJudgecuser;

    @ApiModelProperty(value = "车辆停放的停车场id")
    private Integer carOrgid;

    @ApiModelProperty(value = "车辆进入时间")
    private LocalDateTime carEntertime;

    @ApiModelProperty(value = "车牌照片存放的URL")
    private String carUrl;


}
