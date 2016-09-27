package com.nxy.spider.vo;

import java.io.Serializable;

/**
 * bilibili的接口返回信息
 * Created by snailnan on 2016/9/27.
 */
public class  Bresult <T>  implements Serializable{

    private static final long serialVersionUID = -4135211467298954591L;

    private int code ;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
