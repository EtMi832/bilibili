package com.nxy;

import com.nxy.spider.fetcher.Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * Created by xinyang on 16/6/17.
 */
public class RequestTest {

    public static void testRequest() {
        HttpResponse res = Request.get("http://www.bilibili.com/video/av4995866/")
                .head("name", "nxy")
                .head("name", "hello")
                .query("hello", "world")
                .query("hello", "nxy")
                .end();
        HttpEntity entity = res.getEntity();

            System.out.println(res.getStatusLine().getStatusCode());

    }

    public static void main(String[] args) {
        testRequest();
    }
}
