package com.graduation.server.service;

import com.graduation.server.pojo.Parklist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.server.pojo.Parklist;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface IParklistService extends IService<Parklist> {

    /**
     * 根据停车场id查询计费规则id
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param id
     * @return int
     **/
    int getPriceIdById(Integer id);
}
