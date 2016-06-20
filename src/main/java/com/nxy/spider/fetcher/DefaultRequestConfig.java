package com.nxy.spider.fetcher;

/**
 * 默认的单次请求设置
 * Created by xinyang on 16/6/16.
 */
public class DefaultRequestConfig {
    /**
     * 回应超时时间，缺省为30秒钟
     */
    private int defaultSoTimeout = 30000;
    /**
     * 连接超时时间，缺省为10秒钟
     */
    private int defaultConnectionTimeout = 100000;
    /**
     * 从连接池中请求一个连接的超时时间，默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）：1秒
     */
    private int defaultConnectionRequestTimeout = 1000;


    /**
     * Getter for property 'defaultConnectionTimeout'.
     *
     * @return Value for property 'defaultConnectionTimeout'.
     */
    public int getDefaultConnectionTimeout() {
        return defaultConnectionTimeout;
    }


    /**
     * Getter for property 'defaultConnectionRequestTimeout'.
     *
     * @return Value for property 'defaultConnectionRequestTimeout'.
     */
    public int getDefaultConnectionRequestTimeout() {
        return defaultConnectionRequestTimeout;
    }


    /**
     * Getter for property 'defaultSoTimeout'.
     *
     * @return Value for property 'defaultSoTimeout'.
     */
    public int getDefaultSoTimeout() {
        return defaultSoTimeout;
    }

}
