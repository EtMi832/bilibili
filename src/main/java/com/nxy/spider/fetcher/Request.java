package com.nxy.spider.fetcher;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nxy.spider.except.NoSupportRequestException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 请求类
 * Created by xinyang on 16/6/15.
 */
public class Request implements Serializable {

    private String type = "get";

    private String url = "";

    private HashMap<String, String> headers = Maps.newHashMap();

    private HashMap<String, String[]> params = Maps.newHashMap();

    private final static String URLPATTER = "[a-zA-z]+://[^\\s]*";

    /**
     * 创建一个request
     *
     * @return
     */
    private static Request build(String url) throws NoSupportRequestException {
        Request req = new Request();
        req.setUrl(url);
        req.parseUrl();
        return req;
    }

    /**
     * 格式化URL
     */
    private void parseUrl() throws NoSupportRequestException {
        if (Pattern.matches(URLPATTER, url)) {
            String pairs[] = url.split("\\?");
            String oUrl = pairs[0];
            if (pairs.length > 1) { //有参数 只取第一个?号后的 其他抛弃
                String paramStr = pairs[1];
                String paramPairs[] = paramStr.split("&");
                int pos;
                String paramPair;
                for (int i = 0, length = paramPairs.length; i < length; i++) {
                    paramPair = paramPairs[i];
                    pos = paramPair.lastIndexOf("=");
                    if (pos > -1) {
                        //添加到参数列表
                        query(paramPair.substring(0, pos)
                                , paramPair.substring(pos + 1));
                    }
                }
            }
            this.url = oUrl;
        } else throw new NoSupportRequestException("url错误:" + this.url);
    }

    /**
     * get 请求
     *
     * @param url
     * @return
     */
    public static Request get(String url) throws NoSupportRequestException {
        Request req = build(url);
        req.type = "get";
        return req;
    }

    /**
     * post 请求
     *
     * @param url
     * @return
     */
    public static Request post(String url) throws NoSupportRequestException {
        Request req = build(url);
        req.type = "post";
        return req;
    }

    /**
     * 体检head头
     *
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
     *
     * @param key
     * @param value
     * @return
     */
    public Request query(String key, String value) {
        if (params.containsKey(key)) {
            String[] values = params.get(key);
            int length = values.length;
            String[] newValues = new String[length + 1];
            for (int i = 0; i < length; i++) {
                newValues[i] = values[i];
            }
            newValues[length] = value;
            params.put(key, newValues);
        } else {
            params.put(key, new String[]{value});
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
            BasicHeader header = new BasicHeader(entry.getKey(), entry.getValue());
            headerList.add(header);
        }
        return headerList;
    }


    /**
     * Getter for property 'params'.
     *
     * @return Value for property 'params'.
     */
    public HashMap<String, String[]> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
