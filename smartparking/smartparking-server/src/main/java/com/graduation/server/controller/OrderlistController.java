package com.graduation.server.controller;


import com.graduation.server.pojo.AdminLoginParam;
import com.graduation.server.pojo.Orderlist;
import com.graduation.server.pojo.TimerInquire;
import com.graduation.server.service.IOrderlistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Api(tags = "OrderlistController")
@RestController
@RequestMapping("/orderlist")
public class OrderlistController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOrderlistService orderlistService;

    @ApiOperation(value = "查询所有订单信息")
    @GetMapping("/all")
    public List<Orderlist> getAllOrderlist(){
        return orderlistService.list();
    }

    @ApiOperation(value = "根据用户id查询订单")
    @GetMapping("/getorderbyuserid/{id}")
    public List<Orderlist> getOrderByCuserId(@PathVariable String id){
        return orderlistService.getOrderByCuserId(id);
    }

    @ApiOperation(value = "根据停车场id查询订单信息")
    @GetMapping("/getorderbyparkid/{id}")
    public List<Orderlist> getOrderByParkId(@PathVariable Integer id){
        return orderlistService.getOrderByParkId(id);
    }

    @ApiOperation(value = "根据车牌号查询订单信息")
    @GetMapping("/getorderbycarnumber/{number}")
    public List<Orderlist> getOrderByCarNumber(@PathVariable String number){
        return orderlistService.getOrderByCarNumber(number);
    }

    @ApiOperation(value = "根据进入时间段查询订单信息")
    @PostMapping("/getorderbyintime")
    public List<Orderlist> getOrderByInTime(@RequestBody TimerInquire timerInquire){

//        String start = timerInquire.getStartyear() + "-" +timerInquire.getStartmonth() + "-" +timerInquire.getStartday()
//                + " " + timerInquire.getStarthour() + ":" +timerInquire.getStartminute() + ":" +"00";
//        Timestamp starttime = Timestamp.valueOf(start);
//
//        String end = timerInquire.getEndyear() + "-" +timerInquire.getEndmonth() + "-" +timerInquire.getEndday()
//                + " " + timerInquire.getEndhour() + ":" +timerInquire.getEndminute() + ":" +"00";
//        Timestamp endtime = Timestamp.valueOf(end);

        Timestamp starttime= timerInquire.getStarttime();
        Timestamp endtime = timerInquire.getEndtime();

        return orderlistService.getOrderByInTime(starttime,endtime);
    }

    @ApiOperation(value = "根据离开时间段查询订单信息")
    @PostMapping("/getorderbyouttime")
    public List<Orderlist> getOrderByOutTime(@RequestBody TimerInquire timerInquire){
//        String start = timerInquire.getStartyear() + "-" +timerInquire.getStartmonth() + "-" +timerInquire.getStartday()
//                + " " + timerInquire.getStarthour() + ":" +timerInquire.getStartminute() + ":" +"00";
//        Timestamp starttime = Timestamp.valueOf(start);
//
//        String end = timerInquire.getEndyear() + "-" +timerInquire.getEndmonth() + "-" +timerInquire.getEndday()
//                + " " + timerInquire.getEndhour() + ":" +timerInquire.getEndminute() + ":" +"00";
//        Timestamp endtime = Timestamp.valueOf(end);

        Timestamp starttime= timerInquire.getStarttime();
        Timestamp endtime = timerInquire.getEndtime();

        return orderlistService.getOrderByOutTime(starttime,endtime);
    }

    @ApiOperation(value = "根据进入时间段和停车场id查询订单信息")
    @PostMapping("/getorderbyidandin")
    public List<Orderlist> getOrderByIdAndIn(@RequestBody TimerInquire timerInquire){

//        String start = timerInquire.getStartyear() + "-" +timerInquire.getStartmonth() + "-" +timerInquire.getStartday()
//                + " " + timerInquire.getStarthour() + ":" +timerInquire.getStartminute() + ":" +"00";
//        Timestamp starttime = Timestamp.valueOf(start);
//
//        String end = timerInquire.getEndyear() + "-" +timerInquire.getEndmonth() + "-" +timerInquire.getEndday()
//                + " " + timerInquire.getEndhour() + ":" +timerInquire.getEndminute() + ":" +"00";
//        Timestamp endtime = Timestamp.valueOf(end);

        Timestamp starttime= timerInquire.getStarttime();
        Timestamp endtime = timerInquire.getEndtime();

        return orderlistService.getOrderByIdAndIn(starttime,endtime,timerInquire.getOrgid());
    }


    @ApiOperation(value = "根据离开时间段和停车场id查询订单信息")
    @PostMapping("/getorderbyidandout")
    public List<Orderlist> getOrderByIdAndOut(@RequestBody TimerInquire timerInquire){
//        String start = timerInquire.getStartyear() + "-" +timerInquire.getStartmonth() + "-" +timerInquire.getStartday()
//                + " " + timerInquire.getStarthour() + ":" +timerInquire.getStartminute() + ":" +"00";
//        Timestamp starttime = Timestamp.valueOf(start);
//
//        String end = timerInquire.getEndyear() + "-" +timerInquire.getEndmonth() + "-" +timerInquire.getEndday()
//                + " " + timerInquire.getEndhour() + ":" +timerInquire.getEndminute() + ":" +"00";
//        Timestamp endtime = Timestamp.valueOf(end);

        Timestamp starttime= timerInquire.getStarttime();
        Timestamp endtime = timerInquire.getEndtime();

        return orderlistService.getOrderByIdAndOut(starttime,endtime,timerInquire.getOrgid());
    }

}
