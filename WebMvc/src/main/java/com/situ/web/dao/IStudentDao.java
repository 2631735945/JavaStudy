package com.situ.web.dao;

import com.situ.web.pojo.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> selectAll();
    void deleteById( Integer id);
    void add(Student student);
    Student selectById(Integer id);
    void update(Student student);
}
