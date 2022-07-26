package com.situ.web.service;

import com.situ.web.pojo.Teacher;
import com.situ.web.util.PageInfo;

import java.util.List;

public interface ITeacherService {
    List<Teacher> selectPage(Integer offset, Integer pageSize);

    int selectCount();

    PageInfo selectByPage(Integer pageNo, Integer pageSize);

    void deleteById(Integer id);

    void add(Teacher teacher);

    Teacher selectById(Integer id);

    void update(Teacher teacher);

}
