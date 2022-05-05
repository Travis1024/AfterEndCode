package com.graduation.server.controller;


import com.graduation.server.pojo.Parklist;
import com.graduation.server.pojo.RespBean;
import com.graduation.server.service.IParklistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Api(tags = "ParklistController")
@RestController
@RequestMapping("/parklist")
public class ParklistController {
    @Autowired
    private IParklistService parklistService;

    @ApiOperation(value = "查询停车场信息")
    @GetMapping("/")
    public List<Parklist> getAllParklist(){
        List<Parklist> result = new ArrayList<>();
        List<Parklist> list = parklistService.list();

        Iterator<Parklist> it = list.iterator();
        while (it.hasNext()) {
            Parklist parklist = it.next();
            parklist.setOrgUnlockpassword("Confidential information!");
            result.add(parklist);
        }

        return result;
    }

    @ApiOperation(value = "新增停车场信息")
    @PostMapping("/")
    public RespBean addParklist(@RequestBody Parklist parklist){
        if(parklistService.save(parklist)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @ApiOperation(value = "修改停车场信息")
    @PutMapping("/")
    public RespBean updateParklist(@RequestBody Parklist parklist){
        if (parklistService.updateById(parklist)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation(value = "根据停车场id查询计费规则id")
    @GetMapping("/getpriceidbyid/{id}")
    public int getPriceIdByid(@PathVariable Integer id){
        return parklistService.getPriceIdById(id);
    }
}
