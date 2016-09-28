package com.nxy.spider.scheduler;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by snailnan on 2016/9/28.
 */
public class BiliExecutorService {

    private static  ExecutorService requestExecutor;
    public static final int POOL_NUM = Runtime.getRuntime().availableProcessors();
    public static ExecutorService getRequest(){
        if (requestExecutor == null){
            synchronized (BiliExecutorService.class){
                if (requestExecutor == null){
                    ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("bili-request-pool").build();
                    requestExecutor = Executors.newFixedThreadPool(POOL_NUM,tf);
                }
            }
        }
        return  requestExecutor;
    }

}
