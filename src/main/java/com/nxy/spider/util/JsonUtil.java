package com.nxy.spider.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.nxy.spider.entiy.AvPlayInfo;
import com.nxy.spider.vo.Bresult;

/**
 * Created by xinyang on 16/6/20.
 */
public class JsonUtil {
	/**
	 * 获取bean
	 * @param json
	 * @param clazz
	 * @param <T>
     * @return
     */
	public static  <T> T getBean(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
    /**
     * 获取bean
     * @param <T>
     * @param json json
     * @return
     */
	public static  <T> T getBean(String json, TypeReference<T> type) {
		return JSON.parseObject(json, type);
	}
}
