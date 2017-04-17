package com.hedou.handler;

import com.framework.exceptions.NotLoginException;
import com.hedou.json.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        queryJson.setRetcode("0005");
        queryJson.setErrorMsg("用户尚未登录！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public BaseJson NumberFormatExceptionHandler(NumberFormatException e){
        queryJson = new BaseJson();
        queryJson.setRetcode("0006");
        queryJson.setErrorMsg("请检查请求参数是否正确！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseJson ExceptionHandler(Exception e){
        queryJson = new BaseJson();
        queryJson.setRetcode("0003");
        queryJson.setErrorMsg("服务器出现异常！");
        log.error(e.getMessage());
        e.printStackTrace();
        return queryJson;
    }
}
