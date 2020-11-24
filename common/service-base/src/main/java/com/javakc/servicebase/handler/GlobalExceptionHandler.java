package com.javakc.servicebase.handler;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author 宋涛
 * @version V1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APICODE errorHandler(Exception e){
        e.printStackTrace();
        //链式编程，自己掉自己，返回APICODE
        return APICODE.ERROR().message("Exception:服务器异常");
    }

    @ExceptionHandler(HctfException.class)
    @ResponseBody
    public APICODE errorHandler(HctfException e) {
        e.printStackTrace();
        //直接取到设定的HctfException里面的值
        return APICODE.ERROR().message(e.getMsg()).code(e.getCode());
    }

}
