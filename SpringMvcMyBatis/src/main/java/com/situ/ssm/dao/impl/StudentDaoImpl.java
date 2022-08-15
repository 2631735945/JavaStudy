package com.situ.ssm.dao.impl;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao {
    private SqlSession sqlSession;

    public StudentDaoImpl() {
      sqlSession= MyBatisUtil.getSqlSession();
    }

    @Override
    public List<Student> selectAll() {
        System.out.println("StudentDaoImpl.selectAll");
        List<Student> list = sqlSession.selectList("selectAll");
        System.out.println(sqlSession);
        return list;
    }

    @Override
    public List<Student> selectPage(Integer offset, Integer pageSize) {
        System.out.println("StudentDaoImpl.selectPage");
        Map<String,Object> map=new HashMap<>();
        map.put("offset",offset);
        map.put("pageSize",pageSize);

        List<Student> list=sqlSession.selectList("selectPage",map);
        System.out.println(sqlSession);
        return list;
    }

    @Override
    public int selectCount() {
        System.out.println("StudentDaoImpl.selectCount");
        return sqlSession.selectOne("selectCount");
    }

    @Override
    public int deleteById(Integer id) {
        System.out.println();
        int count = sqlSession.delete("deleteById", id);
        System.out.println(sqlSession);
        sqlSession.commit();
        return count;
    }

    @Override
    public int insertStudent(Student student) {
        System.out.println("StudentDaoImpl.insertStudent");
        int count = sqlSession.insert("insertStudent", student);
        System.out.println(sqlSession);
        sqlSession.commit();
        return count;
    }

    @Override
    public int updateStudent(Map<String,Object> map) {
        System.out.println("StudentDaoImpl.updateStudent");
        int count = sqlSession.update("updateStudent", map);
        return count;
    }
}
