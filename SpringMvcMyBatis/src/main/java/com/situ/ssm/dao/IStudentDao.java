package com.situ.ssm.dao;

import com.situ.ssm.pojo.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    public List<Student> selectAll();
    public List<Student> selectPage(Integer offset,Integer pageSize);
    public int selectCount();

    public  int deleteById(Integer id);

    public int insertStudent(Student student);
    public int updateStudent(Map<String,Object> map);
}
