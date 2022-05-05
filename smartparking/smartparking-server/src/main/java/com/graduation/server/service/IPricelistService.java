package com.graduation.server.service;

import com.graduation.server.pojo.Pricelist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.server.pojo.Pricelist;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface IPricelistService extends IService<Pricelist> {

    /**
     * 根据id查询计费规则
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Pricelist>
     **/
    Pricelist getPriceById(Integer id);
}
