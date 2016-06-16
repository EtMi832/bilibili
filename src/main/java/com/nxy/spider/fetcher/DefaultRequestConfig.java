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
     * Setter for property 'defaultConnectionTimeout'.
     *
     * @param defaultConnectionTimeout Value to set for property 'defaultConnectionTimeout'.
     */
    public void setDefaultConnectionTimeout(int defaultConnectionTimeout) {
        this.defaultConnectionTimeout = defaultConnectionTimeout;
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
     * Setter for property 'defaultConnectionRequestTimeout'.
     *
     * @param defaultConnectionRequestTimeout Value to set for property 'defaultConnectionRequestTimeout'.
     */
    public void setDefaultConnectionRequestTimeout(int defaultConnectionRequestTimeout) {
        this.defaultConnectionRequestTimeout = defaultConnectionRequestTimeout;
    }

    /**
     * Getter for property 'defaultSoTimeout'.
     *
     * @return Value for property 'defaultSoTimeout'.
     */
    public int getDefaultSoTimeout() {
        return defaultSoTimeout;
    }

    /**
     * Setter for property 'defaultSoTimeout'.
     *
     * @param defaultSoTimeout Value to set for property 'defaultSoTimeout'.
     */
    public void setDefaultSoTimeout(int defaultSoTimeout) {
        this.defaultSoTimeout = defaultSoTimeout;
    }
}
