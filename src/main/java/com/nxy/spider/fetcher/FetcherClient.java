package com.nxy.spider.fetcher;

import com.nxy.spider.util.ParamsUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 负责爬取网页内容
 * Created by xinyang on 16/6/15.
 */
public class FetcherClient {

    private final static Logger log = Logger.getLogger(FetcherClient.class);

    private final static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

    static {
        // 默认请求参数
        httpClientBuilder.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36");
        DefaultRequestConfig defaultRequestConfig = new DefaultRequestConfig();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(defaultRequestConfig.getDefaultConnectionRequestTimeout())
                .setConnectTimeout(defaultRequestConfig.getDefaultConnectionTimeout())
                .setSocketTimeout(defaultRequestConfig.getDefaultSoTimeout())
                .setExpectContinueEnabled(false)
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
        ArrayList<Header> defaultheaders = new ArrayList<Header>();
        defaultheaders.add(new BasicHeader("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
        defaultheaders.add(new BasicHeader("Accept-Encoding","gzip, deflate, sdch"));
        defaultheaders.add(new BasicHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6"));
        httpClientBuilder.setDefaultHeaders(defaultheaders);
    }

    public void execute(Request request) {

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpUriRequest urlrequest = new HttpGet("");
        try {
            closeableHttpClient.execute(urlrequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private HttpGet createHttpGet(Request request){

        String params = ParamsUtil.toUrl(request.getParams());
        HttpGet httpGet = new HttpGet(request.getUrl()+params);
        httpGet.setHeaders((Header[]) request.getHeaders().toArray());
        return httpGet;
    }

    private HttpPost createHttpPost(Request request){

        HttpPost httpPost = new HttpPost(request.getUrl());
        HashMap<String,String> params =request.getParams();

        List<BasicNameValuePair> parameters =
                ParamsUtil.toNameValuePair(request.getParams());
        HttpEntity entiy = null;
        try {
            entiy = new UrlEncodedFormEntity(parameters,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(entiy);
        return httpPost;
    }

}
