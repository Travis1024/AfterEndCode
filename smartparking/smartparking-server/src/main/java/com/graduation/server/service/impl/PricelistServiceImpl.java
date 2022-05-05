package com.graduation.server.service.impl;

import com.graduation.server.pojo.Pricelist;
import com.graduation.server.mapper.PricelistMapper;
import com.graduation.server.service.IPricelistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PricelistServiceImpl extends ServiceImpl<PricelistMapper, Pricelist> implements IPricelistService {

    @Autowired
    private PricelistMapper pricelistMapper;

    /**
     * 根据id查询计费规则
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param id
     * @return java.util.List<com.graduation.server.pojo.Pricelist>
     **/
    @Override
    public Pricelist getPriceById(Integer id) {
        return pricelistMapper.getPriceById(id);
    }
}
