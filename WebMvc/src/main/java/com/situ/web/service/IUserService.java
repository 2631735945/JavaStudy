package com.situ.web.service;

import com.situ.web.pojo.User;
import com.situ.web.util.PageInfo;

import java.util.List;

public interface IUserService {
    int deleteById(Integer id);
    int add(User user,String name);
    User selectById(Integer id);
    User selectByName(String name);
    List<User> selectAll();
    User selectByMsg(String name,String password);
    int selectCount();

    List<User> selectPage(Integer offset, Integer pageSize);
    PageInfo selectByPage(Integer pageNo, Integer pageSize);
    int update(User user);
}
