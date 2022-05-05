package com.graduation.server.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.graduation.server.pojo.Incar;
import com.graduation.server.pojo.RespBean;
import com.graduation.server.service.IIncarService;
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
@Api(tags = "IncarController")
@RestController
@RequestMapping("/incar")
public class IncarController {

    @Autowired
    private IIncarService incarService;

    @ApiOperation(value = "查询现有车辆")
    @GetMapping("/allcar")
    public List<Incar> getAllCars(){
        return incarService.list();
    }


    @ApiOperation(value = "修改现有信息")
    @PutMapping("/updatecar")
    public RespBean updateCar(@RequestBody Incar incar){
        try {
            int i = incarService.updateCar(incar);
            if(i != 0){
                return RespBean.success("修改成功！");
            }
            return RespBean.error("修改失败！");
        }catch (Exception e){
            return RespBean.error("异常错误！",e);
        }
    }

    @ApiOperation(value = "手动处理离开")
    @DeleteMapping("/handleleft/{carnumber}")
    public RespBean handleLeft(@PathVariable String carnumber){
        try {
            Incar incar = getRecord(carnumber);
            if (!incarService.deleteOneNumber(incar.getCarOrgid())){
                return RespBean.error("操作失败！");
            }
            int i = incarService.handleLeft(carnumber);
            if(i != 0){
                return RespBean.success("操作成功！");
            }
            return RespBean.error("操作失败！");
        }catch (Exception e){
            return RespBean.error("异常错误！",e);
        }
    }

    @ApiOperation(value = "根据车牌删除车辆信息")
    @DeleteMapping("/deletecar/{number}")
    public RespBean deleteCar(@PathVariable String number){
        Incar incar = getRecord(number);
        if (!incarService.deleteOneNumber(incar.getCarOrgid())){
            return RespBean.error("删除失败！");
        }
        if(incarService.deleteCar(number)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "新增进入车辆")
    @PostMapping("/addincar")
    public RespBean addIncar(@RequestBody Incar incar){
        try {
            if (!incarService.addOneNumber(incar.getCarOrgid())){
                return RespBean.error("新增失败！");
            }
            int i = incarService.addIncar(incar);
            if(i != 0){
                return RespBean.success("新增成功！");
            }
            return RespBean.error("新增失败！");
        }catch (Exception e){
//            return RespBean.error("异常错误，请检查数据库中该ID是否已经存在！");
            return RespBean.error(e.toString());
        }
    }

    @ApiOperation(value = "根据车牌号查询记录")
    @GetMapping("/getrecord/{carnumber}")
    public Incar getRecord(@PathVariable String carnumber){
        return incarService.getRecord(carnumber);
    }

}
