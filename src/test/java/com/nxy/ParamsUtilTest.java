package com.nxy;

import com.nxy.spider.util.ParamsUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinyang on 16/6/16.
 */
public class ParamsUtilTest extends TestCase{

    @Test
    public void testtoUrl1(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("hello","world");
        String url = ParamsUtil.toUrl(params);
        assertEquals("hello=world",url);
    }
    @Test
    public void testtoUrl2(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("hello","world");
        params.put("name","nxy");
        String url = ParamsUtil.toUrl(params);
        boolean result = url.equals("hello=world&name=nxy")
                || url.equals("name=nxy&hello=world");

        assertTrue(result);

    }
}
