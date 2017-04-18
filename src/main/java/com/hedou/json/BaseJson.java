package com.hedou.json;

import java.io.Serializable;
/**
 *
 * File name：BaseJson
 * Description：JSON基础结构，包含响应码和响应消息，反馈给前台页面
 */
public class BaseJson implements Serializable,Cloneable {

    private int errno;//响应代码 0-正确 1-错误
    private String errmsg;//错误消息

    private Object obj;
    public BaseJson()
    {
        errno = 0;
        obj = null;
    }

    public BaseJson(int errno){
        this.errno = errno;
        obj = null;
    }

    public int getErrno() {
        return errno;
    }
    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
