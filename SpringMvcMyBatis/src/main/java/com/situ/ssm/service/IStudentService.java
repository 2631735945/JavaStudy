package com.situ.ssm.service;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.util.LayUITableJSONResult;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    public List<Student> selectAll();
    public List<Student> selectPage(Integer offset,Integer pageSize);
    public LayUITableJSONResult selectByPage(Integer page,Integer limit);
    public int selectCount();
    public  int deleteById(Integer id);
    public int deleteAll(String[] ids);
    public int insertStudent(Student student);
    public int updateStudent(Map<String,Object> map);
}
