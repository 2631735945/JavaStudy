package com.situ.spring.service.impl;

import com.situ.spring.dao.IStudentDao;
import com.situ.spring.pojo.Student;
import com.situ.spring.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void selectAll() {
        System.out.println("StudentServiceImpl.selectAll");
        studentDao.selectAll();

    }
}
