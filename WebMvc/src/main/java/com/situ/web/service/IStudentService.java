package com.situ.web.service;

import com.situ.web.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAll();
    void deleteById( Integer id);
    void add(Student student);
    Student selectById(Integer id);
    void update(Student student);
}
