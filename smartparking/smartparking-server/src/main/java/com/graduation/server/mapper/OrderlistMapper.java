package com.graduation.server.mapper;

import com.graduation.server.pojo.Orderlist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Orderlist;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface OrderlistMapper extends BaseMapper<Orderlist> {

    /**
     * 根据用户id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByCuserId(String id);

    /**
     * 根据停车场id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByParkId(Integer id);

    /**
     * 根据车牌号查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param number
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByCarNumber(String number);

    /**
     * 根据进入时间段查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param start_time
     * @param end_time
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/

    List<Orderlist> getOrderByInTime(Timestamp start_time, Timestamp end_time);

    /**
     * 根据离开时间段查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param starttime
     * @param endtime
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByOutTime(Timestamp starttime, Timestamp endtime);


    /**
     * 根据进入时间段和停车场id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param starttime
     * @param endtime
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByIdAndIn(Timestamp starttime, Timestamp endtime, Integer orgid);


    /**
     * 根据离开时间段和停车场id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param starttime
     * @param endtime
     * @param orgid
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    List<Orderlist> getOrderByIdAndOut(Timestamp starttime, Timestamp endtime, Integer orgid);


    /**
     * 新增订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/29
     * @param carnumber
     * @param carnumbercolor
     * @param cartype
     * @param carjudgecuser
     * @param carorgid
     * @param carentertime
     * @param carlefttime
     * @param cost
     * @param carinurl
     * @param carouturl
     * @param carneedpay
     * @return int
     **/

    int addNewOrder(String carnumber, String carnumbercolor, String cartype, Integer carjudgecuser, Integer carorgid, Timestamp carentertime, Timestamp carlefttime, double cost, String carinurl,String carouturl,double carneedpay);
}
