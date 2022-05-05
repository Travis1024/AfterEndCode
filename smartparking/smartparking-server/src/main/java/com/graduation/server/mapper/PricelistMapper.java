package com.graduation.server.mapper;

import com.graduation.server.pojo.Pricelist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.server.pojo.Pricelist;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
public interface PricelistMapper extends BaseMapper<Pricelist> {

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
