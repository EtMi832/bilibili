package com.nxy.spider.fetcher;

import org.apache.http.Header;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 请求类
 * Created by xinyang on 16/6/15.
 */
public class Request implements Serializable{

    private String type = "get";

    private String url ="";

    private ArrayList<Header> headers = new ArrayList<Header>(3);

    private HashMap<String,String> params = new HashMap<String, String>();

    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Getter for property 'url'.
     *
     * @return Value for property 'url'.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for property 'url'.
     *
     * @param url Value to set for property 'url'.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Getter for property 'headers'.
     *
     * @return Value for property 'headers'.
     */
    public ArrayList<Header> getHeaders() {
        return headers;
    }

    /**
     * Setter for property 'headers'.
     *
     * @param headers Value to set for property 'headers'.
     */
    public void setHeaders(ArrayList<Header> headers) {
        this.headers = headers;
    }

    /**
     * Getter for property 'params'.
     *
     * @return Value for property 'params'.
     */
    public HashMap<String, String> getParams() {
        return params;
    }

    /**
     * Setter for property 'params'.
     *
     * @param params Value to set for property 'params'.
     */
    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
}
