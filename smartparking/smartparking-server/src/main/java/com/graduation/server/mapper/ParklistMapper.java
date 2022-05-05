package com.graduation.server.mapper;

import com.graduation.server.pojo.Parklist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Parklist;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface ParklistMapper extends BaseMapper<Parklist> {


    /**
     * 根据停车场id查询计费规则id
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param id
     * @return int
     **/
    int getPriceIdById(Integer id);

    /**
     * 根据停车场id增加一个占用车位
     *
     * @author travis-wei
     * @createTime 2022/4/1
     * @param orgid
     * @return int
     **/

    int addOneNumber(Integer orgid);


    /**
     * 根据停车场id减少一个占用车位
     *
     * @author travis-wei
     * @createTime 2022/4/1
     * @param orgid
     * @return int
     **/

    int deleteOneNumber(Integer orgid);
}
