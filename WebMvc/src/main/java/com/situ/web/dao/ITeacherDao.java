package com.situ.web.dao;

import com.mysql.jdbc.UpdatableResultSet;
import com.situ.web.pojo.Teacher;
import com.situ.web.util.PageInfo;

import java.util.List;

public interface ITeacherDao {
//    分页
    List<Teacher> selectPage(Integer offset,Integer pageSize);
    int selectCount();
    void deleteById(Integer id);
    void add(Teacher teacher);
    Teacher selectById(Integer id);
    void update(Teacher teacher);

}
