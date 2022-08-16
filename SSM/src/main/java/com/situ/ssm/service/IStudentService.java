package com.situ.ssm.service;

import com.situ.ssm.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAll();
}
