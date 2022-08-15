package com.situ.ssm.dao.impl;

import com.situ.ssm.dao.IUserDao;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.pojo.User;
import com.situ.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoImpl implements IUserDao {
    private SqlSession sqlSession;

    public UserDaoImpl() {
        sqlSession = MyBatisUtil.getSqlSession();
    }

    @Override
    public User login(Map<String, Object> map) {
        System.out.println("UserDaoImpl.login");
        User user = sqlSession.selectOne("login", map);
        return user;
    }

    @Override
    public User selectByName(String name) {
        System.out.println("UserDaoImpl.selectByName");
        User user = sqlSession.selectOne("selectByName", name);
        return user;

    }

    @Override
    public int register(User user) {
        System.out.println("UserDaoImpl.register");
        int count = sqlSession.insert("register", user);
        return count;
    }
}
