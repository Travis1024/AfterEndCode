package com.graduation.server.service.impl;

import com.graduation.server.pojo.Parklist;
import com.graduation.server.mapper.ParklistMapper;
import com.graduation.server.service.IParklistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Service
public class ParklistServiceImpl extends ServiceImpl<ParklistMapper, Parklist> implements IParklistService {

    @Autowired
    private ParklistMapper parklistMapper;

    /**
     * 根据停车场id查询计费规则id
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param id
     * @return int
     **/
    @Override
    public int getPriceIdById(Integer id) {
        return parklistMapper.getPriceIdById(id);
    }
}
