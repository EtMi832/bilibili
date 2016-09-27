package com.nxy.spider.fetcher;

import com.nxy.spider.except.NoSupportRequestException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.junit.Test;

import java.io.*;

/**
 * Created by snailnan on 2016/9/27.
 */
public class RequestTest {
    @Test
    public void test(){
        try {
            HttpResponse resp = Request.get("http://api.bilibili.com/archive_stat/stat?aid=6365559").end();
            HttpEntity entity = resp.getEntity();
            InputStream in = entity.getContent();
            BufferedInputStream b = new BufferedInputStream(in);
            StringWriter w = new StringWriter();
            int c = b.read();
            while (c > -1){
                w.write(c);
                c= b.read();
            }
            w.flush();
            System.out.println(w.toString());
        } catch (NoSupportRequestException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
