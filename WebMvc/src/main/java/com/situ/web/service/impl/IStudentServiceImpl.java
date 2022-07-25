package com.situ.web.service.impl;

import com.situ.web.dao.IStudentDao;
import com.situ.web.dao.impl.IStudentDaoImpl;
import com.situ.web.pojo.Student;
import com.situ.web.service.IStudentService;

import java.util.List;

public class IStudentServiceImpl implements IStudentService {
    private IStudentDao studentDao=new IStudentDaoImpl();
    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public void update(Student student) {
       studentDao.update(student);
    }
}
