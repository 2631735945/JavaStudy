package com.situ.ssm.mapper;

import com.situ.ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {
     List<Student> selectAll();
}