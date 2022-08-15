package com.situ.spring.dao.impl;

import com.situ.spring.dao.IStudentDao;
import com.situ.spring.pojo.Student;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public void selectAll() {
        System.out.println("StudentDaoImpl.selectAll");

    }
}
