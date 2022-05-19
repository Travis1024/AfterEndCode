package com.graduation.server.service.impl;

import com.graduation.server.mapper.*;
import com.graduation.server.pojo.*;
import com.graduation.server.service.IIncarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author travis-wei
 * @since 2022-01-23
 */
@Service
public class IncarServiceImpl extends ServiceImpl<IncarMapper, Incar> implements IIncarService {

    @Autowired
    private IncarMapper incarMapper;

    @Autowired
    private OrderlistMapper orderlistMapper;

    @Autowired
    private ParklistMapper parklistMapper;

    @Autowired
    private PricelistMapper pricelistMapper;

    @Autowired
    private CuserMapper cuserMapper;


    /**
     * 修改现有信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param incar
     * @return int
     **/
    @Override
    public int updateCar(Incar incar) {
        Integer carid = incar.getCarId();
        String carnumber = incar.getCarNumber();
        String carcolor = incar.getCarNumbercolor();
        String cartype = incar.getCarType();
        Integer judgecuser = incar.getCarJudgecuser();
        return incarMapper.updateCar(carid,carnumber,carcolor,cartype,judgecuser);
    }

    public String getTimeStampNumberFormat(Timestamp formatTime) {
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("zh", "cn"));
        return mFormat.format(formatTime);
    }

    /**
     * 手动处理离开
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param carnumber
     * @return int
     **/
    @Override
    public int handleLeft(String carnumber)  {

        Calendar calendar = Calendar.getInstance();

        Incar incar = incarMapper.getRecord(carnumber);

        if (!deleteCar(carnumber)){
            return 0;
        }
        String carnumbercolor = incar.getCarNumbercolor();
        String cartype = incar.getCarType();
        Integer carjudgecuser = incar.getCarJudgecuser();
        Integer carorgid = incar.getCarOrgid();
        Timestamp carentertime = Timestamp.valueOf(incar.getCarEntertime());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = formatter.format(calendar.getTime());
        Timestamp carlefttime = Timestamp.valueOf(nowtime);
        String carinurl = incar.getCarUrl();
        String carouturl = "Handle By Admin,Null!";

        double cost = 0;
        //实现金额计算方法
        double carneedpay = 0;
        double balance = 0;

        long t1 = 0L;
        long t2 = 0L;

        try {
            t1 = formatter.parse(getTimeStampNumberFormat(carlefttime)).getTime();
        }catch (ParseException e){
            e.printStackTrace();
        }
        try {
            t2 = formatter.parse(getTimeStampNumberFormat(carentertime)).getTime();
        }catch (ParseException e){
            e.printStackTrace();
        }

        int hours=(int) ((t1 - t2)/(1000*60*60));
        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
        int alltime = hours * 60 + minutes;


        int priceid = parklistMapper.getPriceIdById(carorgid);
        Pricelist pricelist = pricelistMapper.getPriceById(priceid);

        int freetime = pricelist.getPriceFreetime();
        int secondtime = pricelist.getPriceSecondtime();
        int othertime = alltime - freetime - secondtime;

        double secondprice = pricelist.getPriceSecondprice();
        double otherprice = pricelist.getPriceOtherprice();
        double maxprice = pricelist.getPriceMaxprice();

        if (alltime <= freetime){
            cost = 0;
        }else if (alltime <= (freetime + secondtime)){
            cost = (alltime-freetime) * secondprice;
        }else {
            cost = secondtime * secondprice + othertime * otherprice;
            if (cost > maxprice){
                cost = maxprice;
            }
        }

        Cuser cusernew = cuserMapper.getCuserByCarNumber(carnumber);
        if (cusernew == null){
            carjudgecuser = 0;
        }

        if (carjudgecuser == 1){
            //常驻用户
            Cuser cuser = cuserMapper.getCuserByCarNumber(carnumber);
            balance = cuser.getCuserBalance();
            if (balance >= cost){
                //说明账户中的余额够用
                carneedpay = 0;
                cuserMapper.updateBalance(carnumber,balance - cost);
            }else{
                //账户中的余额不够用
                carneedpay = cost - balance;
                //$$$$$$$修改余额函数
                cuserMapper.updateBalance(carnumber,0);
            }
        }else {
            //临时用户
            carneedpay = cost;
        }

        return orderlistMapper.addNewOrder(carnumber,carnumbercolor,cartype,carjudgecuser,carorgid,carentertime,carlefttime,cost,carinurl,carouturl,carneedpay);

    }

    /**
     * 根据车牌删除车辆信息
     *
     * @author travis-wei
     * @createTime 2022/3/24
     * @param number
     * @return boolean
     **/
    @Override
    public boolean deleteCar(String number) {
        return incarMapper.deleteCar(number);
    }


    /**
     * 新增进入车辆
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param incar
     * @return int
     **/

    @Override
    public int addIncar(Incar incar) {
        String carnumber = incar.getCarNumber();
        String carnumbercolor = incar.getCarNumbercolor();
        String cartype = incar.getCarType();

        Cuser cuser = cuserMapper.getCuserByCarNumber(carnumber);

        int carjudgecuser = 1;
        if (cuser == null){
            carjudgecuser = 0;
        }

        int carorgid = incar.getCarOrgid();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = formatter.format(calendar.getTime());
        Timestamp carentertime = Timestamp.valueOf(nowtime);

        String carurl = "Add By Admin, NULL!";

        return incarMapper.addIncar(carnumber,carnumbercolor,cartype,carjudgecuser,carorgid,carentertime,carurl);
    }

    /**
     * 根据车牌号查询记录
     *
     * @author travis-wei
     * @createTime 2022/3/28
     * @param carnumber
     * @return com.graduation.server.pojo.Incar
     **/

    @Override
    public Incar getRecord(String carnumber) {
        return incarMapper.getRecord(carnumber);
    }

    @Override
    public boolean addOneNumber(Integer orgid) {

        Parklist parklist = parklistMapper.selectById(orgid);
        if (parklist.getOrgBusynumber() >= parklist.getOrgTotalnumber()){
            return false;
        }
        int i = parklistMapper.addOneNumber(orgid);
        return i > 0;
    }

    @Override
    public boolean deleteOneNumber(Integer orgid) {
        int i = parklistMapper.deleteOneNumber(orgid);
        return i > 0;
    }
}
