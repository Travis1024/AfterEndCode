package com.graduation.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: (启动类)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/23 17:07]
 */
@SpringBootApplication
@MapperScan("com.graduation.server.mapper")
public class SmartParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartParkingApplication.class,args);
    }
}
