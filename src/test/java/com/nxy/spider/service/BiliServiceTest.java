package com.nxy.spider.service;

import com.nxy.Application;
import com.nxy.spider.entiy.AvPlayInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by snailnan on 2016/9/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BiliServiceTest {
    @Autowired
    private BiliService biliService;
    
    @Test
    public void getAvPlayInfo(){
        int avid = 6365559;
        AvPlayInfo av = biliService.getAvPlayInfo(avid);
        System.out.println(av.toString());
    }
}
