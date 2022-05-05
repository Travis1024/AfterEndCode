package com.graduation.server.service;

import com.graduation.server.pojo.Incar;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.server.pojo.Incar;
import com.graduation.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface IIncarService extends IService<Incar> {


    /**
     * 修改现有车辆信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param incar
     * @return int
     **/
    int updateCar(Incar incar);


    /**
     * 手动处理离开
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param carnumber
     * @return int
     **/
    int handleLeft(String carnumber);

    /**
     * 删除车辆信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param number
     * @return boolean
     **/
    boolean deleteCar(String number);

    /**
     * 新增进入车辆
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param incar
     * @return int
     **/
    int addIncar(Incar incar);

    /**
     * 根据车牌号查询记录
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param carnumber
     * @return com.graduation.server.pojo.Incar
     **/
    Incar getRecord(String carnumber);


    /**
     * 根据停车场id增加一个占用车位
     *
     * @author travis-wei
     * @createTime 2022/4/1
     * @param orgid
     * @return boolean
     **/
    boolean addOneNumber(Integer orgid);

    /**
     * 根据停车场id减少一个占用车位
     *
     * @author travis-wei
     * @createTime 2022/4/1
     * @param orgid
     * @return boolean
     **/
    boolean deleteOneNumber(Integer orgid);
}
