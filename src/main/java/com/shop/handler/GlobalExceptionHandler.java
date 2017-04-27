package com.shop.handler;

import com.framework.exceptions.NotLoginException;
import com.shop.json.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by deru on 2017/1/22.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private BaseJson queryJson = new BaseJson();

    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public BaseJson NotLoginExceptionHandler(NotLoginException e){
        queryJson = new BaseJson();
        queryJson.setErrno(8);
        queryJson.setErrmsg("用户尚未登录！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }

    @ExceptionHandler({NumberFormatException.class,MissingServletRequestParameterException.class, TypeMismatchException.class})
    @ResponseBody
    public BaseJson ParameterExceptionHandler(Exception e){
        queryJson = new BaseJson();
        queryJson.setErrno(9);
        queryJson.setErrmsg("请求参数错误或缺少必须参数！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseJson ExceptionHandler(Exception e){
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        queryJson.setErrmsg("服务器出现异常！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }
}
