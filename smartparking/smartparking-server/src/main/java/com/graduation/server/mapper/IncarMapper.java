package com.graduation.server.mapper;

import com.graduation.server.pojo.Incar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Incar;
import com.graduation.server.pojo.RespBean;
import io.swagger.models.auth.In;

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
public interface IncarMapper extends BaseMapper<Incar> {

    /**
     * 修改现有信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param carid
     * @param carnumber
     * @param carcolor
     * @param cartype
     * @param judgecuser
     * @return int
     **/

    int updateCar(Integer carid, String carnumber, String carcolor, String cartype, Integer judgecuser);

    /**
     * 根据车牌号删除车牌信息
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
     * @param carnumber
     * @param carnumbercolor
     * @param cartype
     * @param carjudgecuser
     * @param carorgid
     * @param carentertime
     * @param carurl
     * @return int
     **/

    int addIncar(String carnumber, String carnumbercolor, String cartype, int carjudgecuser, int carorgid, Timestamp carentertime, String carurl);


    /**
     * 根据车牌号查询记录
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param carnumber
     * @return com.graduation.server.pojo.Incar
     **/

    Incar getRecord(String carnumber);

}
