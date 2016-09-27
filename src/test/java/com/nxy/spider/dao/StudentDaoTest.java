package com.nxy.spider.dao;

import com.alibaba.fastjson.JSON;
import com.nxy.Application;
import com.nxy.spider.entiy.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by canca on 2016/9/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void getStudentById(){
        Student s = studentDao.getById(1L);
        System.out.println(JSON.toJSON(s));
    }
}
