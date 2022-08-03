package com.situ.web.dao;


import com.situ.web.pojo.Teacher;

import java.util.List;

public interface ITeacherDao {
//    分页
    List<Teacher> selectPage(Integer offset,Integer pageSize);
    int selectCount();
    int deleteById(Integer id);
    void add(Teacher teacher);
    Teacher selectById(Integer id);
    void update(Teacher teacher);

}
