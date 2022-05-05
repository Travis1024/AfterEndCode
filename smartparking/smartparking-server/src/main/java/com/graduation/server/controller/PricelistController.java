package com.graduation.server.controller;


import com.graduation.server.pojo.Parklist;
import com.graduation.server.pojo.Pricelist;
import com.graduation.server.pojo.RespBean;
import com.graduation.server.service.IPricelistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Api(tags = "PricelistController")
@RestController
@RequestMapping("/pricelist")
public class PricelistController {

    @Autowired
    private IPricelistService pricelistService;


    @ApiOperation(value = "查询现有计费规则")
    @GetMapping("/")
    public List<Pricelist> getAllPricelist(){
        return pricelistService.list();
    }

    @ApiOperation(value = "新增计费规则")
    @PostMapping("/")
    public RespBean addPricelist(@RequestBody Pricelist pricelist){
        if(pricelistService.save(pricelist)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @ApiOperation(value = "修改计费规则")
    @PutMapping("/")
    public RespBean updatePricelist(@RequestBody Pricelist pricelist){
        if (pricelistService.updateById(pricelist)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation(value = "根据id查询计费规则")
    @GetMapping("/getpricebyid/{id}")
    public Pricelist getPriceById(@PathVariable Integer id){
        return pricelistService.getPriceById(id);
    }
}
