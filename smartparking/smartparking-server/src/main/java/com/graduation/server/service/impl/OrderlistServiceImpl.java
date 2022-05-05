package com.graduation.server.service.impl;

import com.graduation.server.pojo.Orderlist;
import com.graduation.server.mapper.OrderlistMapper;
import com.graduation.server.service.IOrderlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Service
public class OrderlistServiceImpl extends ServiceImpl<OrderlistMapper, Orderlist> implements IOrderlistService {

    @Autowired
    private OrderlistMapper orderlistMapper;


    /**
     * 根据用户id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByCuserId(String id) {
        return orderlistMapper.getOrderByCuserId(id);
    }

    /**
     * 根据停车场id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByParkId(Integer id) {
        return orderlistMapper.getOrderByParkId(id);
    }

    /**
     * 根据车牌号查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param number
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByCarNumber(String number) {
        return orderlistMapper.getOrderByCarNumber(number);
    }

    /**
     * 根据离开时间段查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/23
     * @param start_time
     * @param end_time
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByInTime(Timestamp start_time, Timestamp end_time) {
        return orderlistMapper.getOrderByInTime(start_time,end_time);
    }

    /**
     * 根据离开时间段查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param starttime
     * @param endtime
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByOutTime(Timestamp starttime, Timestamp endtime) {
        return orderlistMapper.getOrderByOutTime(starttime, endtime);
    }


    /**
     * 根据进入时间段和停车场id查询订单信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param starttime
     * @param endtime
     * @return java.util.List<com.graduation.server.pojo.Orderlist>
     **/
    @Override
    public List<Orderlist> getOrderByIdAndIn(Timestamp starttime, Timestamp endtime, Integer orgid) {
        return orderlistMapper.getOrderByIdAndIn(starttime, endtime, orgid);
    }

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
    @Override
    public List<Orderlist> getOrderByIdAndOut(Timestamp starttime, Timestamp endtime, Integer orgid) {
        return orderlistMapper.getOrderByIdAndOut(starttime, endtime, orgid);
    }
}
