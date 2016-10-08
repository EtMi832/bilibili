package com.nxy.spider.dao;

import com.nxy.Application;
import com.nxy.spider.entiy.AvPlayInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by snailnan on 2016/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class AvDaoTest {
//    @Autowired
//    private AvDao avDao;

    @Test
    public void saveAvinfo() throws Exception {
//        AvPlayInfo avPlayInfo = new AvPlayInfo();
//        avPlayInfo.setAvid(1L);
//        avDao.saveAvinfo(avPlayInfo);
        System.out.println(1);
    }

}