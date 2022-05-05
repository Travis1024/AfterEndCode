package com.graduation.server.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.graduation.server.pojo.Cuser;
import com.graduation.server.pojo.Orderlist;
import com.graduation.server.pojo.Parklist;
import com.graduation.server.pojo.RespBean;
import com.graduation.server.service.ICuserService;
import com.graduation.server.service.IOrderlistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@Api(tags = "CuserController")
@RestController
@RequestMapping("/cuser")
public class CuserController {
    @Autowired
    private ICuserService cuserService;

    @Autowired
    private IOrderlistService orderlistService;


    private List<Cuser> EncodePassword(List<Cuser> list){
        List<Cuser> result = new ArrayList<>();
        Iterator<Cuser> it = list.iterator();
        while (it.hasNext()) {
            Cuser cuser = it.next();
            cuser.setCuserPassword("!!!Confidential information!!!");
            result.add(cuser);
        }
        return result;
    }

    @ApiOperation(value = "全部用户信息查询")
    @GetMapping("/allinfo")
    public List<Cuser> getAllCusers(){
        return EncodePassword(cuserService.list());
    }

    @ApiOperation(value = "根据用户id查询用户信息")
    @GetMapping("/getcuserbyid/{id}")
    public List<Cuser> getCuserById(@PathVariable String id){
        return EncodePassword(cuserService.getCuserById(id));
    }

    @ApiOperation(value = "根据用户姓名查询用户信息")
    @GetMapping("/getcuserbyname/{name}")
    public List<Cuser> getCuserByName(@PathVariable String name){
        return EncodePassword(cuserService.getCuserByName(name));
    }

    @ApiOperation(value = "根据电话查询用户信息")
    @GetMapping("/getcuserbyphone/{phone}")
    public List<Cuser> getCuserByPhone(@PathVariable String phone){
        return EncodePassword(cuserService.getCuserByPhone(phone));
    }

    @ApiOperation(value = "根据车牌号查询用户信息")
    @GetMapping("/getcuserbycarnumber/{carnumber}")
    public List<Cuser> getCuserByCarNumber(@PathVariable String carnumber){
        List<Cuser> result = new ArrayList<>();
        Cuser cuser = cuserService.getCuserByCarNumber(carnumber);
        cuser.setCuserPassword("!!!Confidential information!!!");
        result.add(cuser);
        return result;
    }

    @ApiOperation(value = "用户信息修改")
    @PutMapping("/updateinfo")
    public RespBean updateCuserInfo(@RequestBody Cuser cuser){
        if (cuserService.updateInfoById(cuser)){
            return RespBean.success("信息修改成功!");
        }
        return RespBean.error("信息修改失败!");
    }

    @ApiOperation(value = "用户余额充值")
    @PutMapping("/recharge")
    public RespBean rechargeCuser(@RequestBody Cuser cuser){
        if (cuserService.rechargeCuser(cuser)){
            return RespBean.success("充值成功!");
        }
        return RespBean.error("充值失败!");
    }

    @ApiOperation(value = "用户新增")
    @PostMapping("/addcuser")
    public RespBean addCuser(@RequestBody Cuser cuser){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String newPassword = passwordEncoder.encode(cuser.getCuserPassword());
        cuser.setCuserPassword(newPassword);

        if (cuserService.save(cuser)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @ApiOperation(value = "用户注销")
    @DeleteMapping("/deletecuser/{id}")
    public RespBean deleteCuser(@PathVariable String id){
        if(cuserService.deleteCuser(id)){
            return RespBean.success("注销成功！");
        }
        return RespBean.error("注销失败！");
    }

    @ApiOperation(value = "根据用户id查询订单信息")
    @GetMapping("/getorderbycuserid/{id}")
    public List<Orderlist> getOrderByCuserId(@PathVariable String id){
        return orderlistService.getOrderByCuserId(id);
    }

    @ApiOperation(value = "根据ID和密码验证密码是否正确")
    @PutMapping("/judgepassword")
    public RespBean judgePassword(@RequestBody Cuser cuser){
        if (cuserService.judgePassword(cuser)){
            return RespBean.success("验证成功！");
        }
        return RespBean.error("验证失败！");
    }

    @ApiOperation(value = "修改用户密码")
    @PutMapping("/changenewpass")
    public RespBean changeNewPassword(@RequestBody Cuser cuser){
        if (cuserService.changeNewPassword(cuser)){
            return RespBean.success("密码修改成功！");
        }
        return RespBean.error("密码修改失败！");
    }

}
