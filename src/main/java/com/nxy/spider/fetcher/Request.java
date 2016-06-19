package com.nxy.spider.fetcher;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nxy.spider.except.NoSupportRequestException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求类
 * Created by xinyang on 16/6/15.
 */
public class Request implements Serializable {

    private String type = "get";

    private String url = "";

    private HashMap<String, String> headers = Maps.newHashMap();

    private HashMap<String, String[]> params = Maps.newHashMap();

    /**
     * 创建一个request
     *
     * @return
     */
    private  static Request build(String url) {
        Request req = new Request();
        try {
            url = URLDecoder.decode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            new NoSupportRequestException();
        }
        return new Request();
    }

    /**
     * get 请求
     * @param url
     * @return
     */
    public static Request get(String url){
        Request req = build(url);
        req.type = "get";
        return req;
    }

    /**
     * post 请求
     * @param url
     * @return
     */
    public static Request post(String url){
        Request req = build(url);
        req.type = "post";
        return req;
    }
    /**
     * 体检head头
     * @param name
     * @param value
     * @return
     */
    public Request head(String name, String value) {
        if (!Strings.isNullOrEmpty(name)) {
            headers.put(name, value);
        }
        return this;
    }

    /**
     * 添加查询参数
     * @param key
     * @param value
     * @return
     */
    public Request query(String key ,String value){
        if(params.containsKey(key)){
            String[] values = params.get(key);
            int length = values.length;
            String []newValues = new String[length+1];
            for (int i = 0; i <length ; i++) {
                newValues[i] = values[i];
            }
            newValues[length] = value;
            params.put(key,newValues);
        }else{
            params.put(key,new String[]{value});
        }
        return this;
    }
    public HttpResponse end() throws NoSupportRequestException {
        HttpResponse rep = null;
        try {
            rep = FetcherClient.execute(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep;
    }
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
        ArrayList<Header> headerList = Lists.newArrayList();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            BasicHeader header = new BasicHeader(entry.getKey(),entry.getValue());
            headerList.add(header);
        }
        return  headerList;
    }


    /**
     * Getter for property 'params'.
     *
     * @return Value for property 'params'.
     */
    public HashMap<String, String[]> getParams() {
        return params;
    }

}
