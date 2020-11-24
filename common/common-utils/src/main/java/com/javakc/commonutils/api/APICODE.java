package com.javakc.commonutils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一数据结果返回
 * @author 宋涛
 * @version V1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
@Data
public class APICODE {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 解释消息
     */
    private String message;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 查询数据
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    public static APICODE OK(){
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.SUCCESS);//取到值20000
        apicode.setMessage("服务调用成功");
        apicode.setSuccess(true);
        return apicode;
    }

    public static APICODE ERROR(){
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.ERROR);//取到值20001
        apicode.setMessage("服务调用失败");
        apicode.setSuccess(false);
        return apicode;
    }

    public APICODE code(Integer code){
        this.setCode(code);
        return this;
    }

    public APICODE message(String message){
        this.setMessage(message);
        return this;
    }

    public APICODE success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public APICODE data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    //第一种方式
//    public APICODE data (String key,Object value){
//        this.data.put(key,value);
//        return this;
//    }

    //第二种方式
    public APICODE data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
