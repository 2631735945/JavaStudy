package com.situ.web.dao;


import com.situ.web.pojo.Teacher;
import com.situ.web.pojo.User;
import com.situ.web.util.PageInfo;

import java.util.List;

public interface IUserDao {
    int deleteById(Integer id);
    int add(User user,String name);
    User selectById(Integer id);
    User selectByName(String name);
    List<User> selectAll();
    //登录用
    User selectByMsg(String name,String password);
    int selectCount();
    List<User> selectPage(Integer offset, Integer pageSize);
   int update(User user);
}
