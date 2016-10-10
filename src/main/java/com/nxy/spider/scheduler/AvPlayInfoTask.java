package com.nxy.spider.scheduler;

import com.nxy.spider.entiy.AvPlayInfo;
import com.nxy.spider.service.BiliService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by snailnan on 2016/9/28.
 */
@Component
public class AvPlayInfoTask implements InitializingBean {
    public static final Logger log = LoggerFactory.getLogger(AvPlayInfo.class);
    @Autowired
    private BiliService biliService;

    @Value("${app.bili.api.avinfo-start}")
    private Long avPlayStardId;

    private AtomicLong curId ;

    @Override
    public void afterPropertiesSet() throws Exception {

        this.curId = new AtomicLong(avPlayStardId);
    }

    /**
     * 每秒执行一次
     */
    @Scheduled(fixedRate = 2000L)
    public void avPlayinfo(){
//        BiliExecutorService.getRequest().submit(()->{
//
//        });
        Long avid = curId.getAndIncrement();
        AvPlayInfo info = biliService.getAvPlayInfo(avid);
        info.setAvid(avid);
        info.setUpdatetime(System.currentTimeMillis());
        log.info("get avinfo avid;{}",avid);
        biliService.saveAvinfo(info);
        log.info("save avinfo avid;{}",avid);
    }

}
