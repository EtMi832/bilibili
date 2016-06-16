package com.nxy.spider.util;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 请求参数类
 * Created by xinyang on 16/6/16.
 */
public class ParamsUtil {
    /**
     * 将参数转化为形如<code>hello=world&name=nxy</code> 格式
     * @param params
     * @return
     */
    public static String toUrl(Map<String,String> params){
        if (params == null || params.isEmpty()){
            return "";
        };
        StringBuilder urlSb = new StringBuilder();
        for (Map.Entry<String,String> entry : params.entrySet()){
            urlSb.append(entry.getKey()).append("=")
                    .append(entry.getValue()).append("&");
        }
        return urlSb.substring(0,urlSb.length()-1);
    }

    /**
     * 将参数转化为
     * @param params BasicNameValuePair{@link NameValuePair}格式
     * @return
     */
    public static List<BasicNameValuePair> toNameValuePair(Map<String,String> params){
        List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
        if (params != null && !params.isEmpty()){
            for (Map.Entry<String,String> entry : params.entrySet()){
                BasicNameValuePair nameValuePair =
                        new BasicNameValuePair( entry.getKey(),entry.getValue());
                nameValuePairs.add(nameValuePair);
            }
        }
        return nameValuePairs;
    }
}
