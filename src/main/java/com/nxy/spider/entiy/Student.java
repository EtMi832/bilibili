package com.nxy.spider.entiy;

import java.io.Serializable;

/**
 * Created by canca on 2016/9/24.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 6362899376031937254L;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
