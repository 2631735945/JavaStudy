package com.situ.web.dao;

import com.situ.web.pojo.User;

import java.util.List;

public interface layUserDao {
    List<User> selectPage(Integer offset,Integer limit);
    int selectTotalCount();

    int deleteById(Integer id);
    int add(User user,String name);
    User selectByName(String name);

    User selectById(Integer id);
    int updateUser(User user);
}
