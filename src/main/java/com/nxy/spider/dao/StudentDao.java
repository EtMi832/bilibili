package com.nxy.spider.dao;

import com.nxy.spider.entiy.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by canca on 2016/9/24.
 */
@Mapper
public interface StudentDao {
    @Select("select * from t_student where id = #{id}")
    Student getById(@Param("id") Long id);
}
