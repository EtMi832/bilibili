package com.nxy.spider.dao;

import com.nxy.spider.entiy.AvPlayInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by snailnan on 2016/10/8.
 */
@Mapper
public interface AvDao {
    @Insert("INSERT INTO b_avplay (`avid`, `view`, `danmuku`, `reply`, `favorite`, `coin`, `share`, `now_rank`, `his_rank`, `updatetime`)" +
            " VALUES (#{a.avid}, #{a.view}, #{a.danmuku},#{a.reply}', #{a.favorite}, #{a.coin},#{a.share}', #{a.now_rank}, #{a.his_rank}, #{a.updatetime});")
    int saveAvinfo(AvPlayInfo avPlayInfo);
}
