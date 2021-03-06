package com.nxy.spider.service;

import com.nxy.spider.entiy.AvPlayInfo;

/**
 * Created by snailnan on 2016/9/27.
 */
public interface BiliService {
    /**
     * 获取av的播放信息
     * @param avId
     * @return
     */
    AvPlayInfo getAvPlayInfo(Long avId);

    /**
     * 保存av播放信息
     * @param bean
     * @return
     */
    boolean saveAvinfo(AvPlayInfo bean);
}
