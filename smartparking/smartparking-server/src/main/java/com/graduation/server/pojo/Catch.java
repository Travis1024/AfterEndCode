package com.graduation.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author travis-wei
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_catch")
@ApiModel(value="Catch对象", description="")
public class Catch implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "缓存id")
    private Integer catchId;

    @ApiModelProperty(value = "该缓存发生的停车场id")
    private Integer catchOrgid;

    @ApiModelProperty(value = "该缓存的类型in/out")
    private String catchType;

    @ApiModelProperty(value = "该缓存对应的车牌号码")
    private String catchNumber;

    @ApiModelProperty(value = "该缓存对应的车牌颜色")
    private String catchColor;

    @ApiModelProperty(value = "该缓存对应的车辆类型")
    private String catchCartype;

    @ApiModelProperty(value = "该缓存创建的时间")
    private LocalDateTime catchTime;

    @ApiModelProperty(value = "该缓存对应的照片URL")
    private String catchUrl;


}
