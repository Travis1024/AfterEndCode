package com.graduation.server.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * description: (时间段类)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/3/23 23:51]
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TimerInquire对象",description = "")
public class TimerInquire {
//    @ApiModelProperty(value = "起始年")
//    private String startyear;
//    @ApiModelProperty(value = "起始月")
//    private String startmonth;
//    @ApiModelProperty(value = "起始天")
//    private String startday;
//    @ApiModelProperty(value = "起始小时")
//    private String starthour;
//    @ApiModelProperty(value = "起始分钟")
//    private String startminute;
//
//    @ApiModelProperty(value = "终止年")
//    private String endyear;
//    @ApiModelProperty(value = "终止月")
//    private String endmonth;
//    @ApiModelProperty(value = "终止天")
//    private String endday;
//    @ApiModelProperty(value = "终止小时")
//    private String endhour;
//    @ApiModelProperty(value = "终止分钟")
//    private String endminute;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp starttime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp endtime;

    @ApiModelProperty(value = "停车场id")
    private Integer orgid;
}
