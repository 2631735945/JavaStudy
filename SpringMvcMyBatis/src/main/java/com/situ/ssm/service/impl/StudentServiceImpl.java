package com.situ.ssm.service.impl;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.dao.impl.StudentDaoImpl;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.util.LayUITableJSONResult;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public List<Student> selectPage(Integer offset, Integer pageSize) {
        return studentDao.selectPage(offset, pageSize);
    }

    @Override
    public int selectCount() {
        return studentDao.selectCount();
    }

    @Override
    public int deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public int deleteAll(String[] ids) {
        int count = 0;
        for (String id : ids) {
            int num = studentDao.deleteById(Integer.parseInt(id));
            if (num > 0) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Map<String,Object> map) {
        System.out.println("StudentServiceImpl.updateStudent");
        return studentDao.updateStudent(map);
    }

    @Override
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        List<Student> list = studentDao.selectPage(offset, limit);
        int count = studentDao.selectCount();
        return LayUITableJSONResult.ok(count, list);

    }


}
