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
@TableName("t_pricelist")
@ApiModel(value="Pricelist对象", description="")
public class Pricelist implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "计费规则id")
    @TableId
    private Integer priceId;

    @ApiModelProperty(value = "计费规则名称")
    private String priceName;

    @ApiModelProperty(value = "计费第一段时间-免费时长")
    private Integer priceFreetime;

    @ApiModelProperty(value = "计费第二段时间-第二段计费时长")
    private Integer priceSecondtime;

    @ApiModelProperty(value = "计费第二段时间-第二段计费单价")
    private Float priceSecondprice;

    @ApiModelProperty(value = "计费第三段时间-第三段计费单价")
    private Float priceOtherprice;

    @ApiModelProperty(value = "单次计费最高金额")
    private Float priceMaxprice;


}
