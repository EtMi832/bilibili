package com.nxy.spider.except;

/**
 * Created by xinyang on 16/6/17.
 */
public class NoSupportRequestException extends Exception{

    public NoSupportRequestException(){
        super();
    }

    public NoSupportRequestException(String message){
        super(message);
    }

    public NoSupportRequestException(String messsage,Throwable throwable){
        super(messsage,throwable);
    }
}
