package com.graduation.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: (公共返回对象)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/24 18:32]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param message
     * @return com.graduation.server.pojo.RespBean
     **/

    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回结果
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param message
     * @param obj
     * @return com.graduation.server.pojo.RespBean
     **/

    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }

    /**
     * 失败返回请求
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param message
     * @return com.graduation.server.pojo.RespBean
     **/

    /**
     * 失败返回结果
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param message
     * @return com.graduation.server.pojo.RespBean
     **/

    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * 失败返回结果
     *
     * @author travis-wei
     * @createTime 2022/1/25
     * @param message
     * @param obj
     * @return com.graduation.server.pojo.RespBean
     **/

    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }
}
