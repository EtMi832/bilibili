package com.nxy;

import com.nxy.spider.except.NoSupportRequestException;
import com.nxy.spider.fetcher.Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * Created by xinyang on 16/6/17.
 */
public class RequestTest {

    public static void testRequest() {
        HttpResponse res = null;
        try {
            Request req = Request.get("http://www.bilibili.com/video/av4995866/");
            res = req.head("name", "nxy")
                    .head("name", "hello")
                    .query("hello", "world")
                    .query("hello", "nxy")
                    .end();
        } catch (NoSupportRequestException e) {
            e.printStackTrace();
        }
        HttpEntity entity = res.getEntity();

        System.out.println(res.getStatusLine().getStatusCode());

    }

    public static void main(String[] args) {
        testRequest();
    }
}
