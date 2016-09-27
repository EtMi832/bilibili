package com.nxy.spider.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by xinyang on 16/6/20.
 */
public class JsonUtil {
    /**
     * 获取bean
     * @param json json
     * @param clazz
     * @param <T>
     * @return
     */
	public static  <T> T getBean(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
}
