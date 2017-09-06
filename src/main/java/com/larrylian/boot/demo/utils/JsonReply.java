package com.larrylian.boot.demo.utils;

import com.larrylian.boot.demo.contants.ReplyContants;

/**
 * Created by Larry 06/09/2017
 */
public class JsonReply {

    private String code;
    private String msg;
    private Object data;
    public JsonReply(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    //成功时返回函数
    public static JsonReply success(Object data){
        return new JsonReply(ReplyContants.OK_CODE, ReplyContants.OK_MSG, data);
    }
    //失败时
    public static JsonReply error(String code, String msg) {
        return new JsonReply(code, msg, null);
    }
}
