package com.situ.web.service;

import com.situ.web.pojo.User;
import com.situ.web.util.LayUITableJSONResult;

import java.util.List;

public interface layUserService {
    List<User> selectPage(Integer offset, Integer limit);
    int selectTotalCount();
    LayUITableJSONResult selectByPage(Integer page, Integer limit);
    int deleteById(Integer id);
    int deleteAll(String[] ids);
    int add(User user,String name);
    User selectByName(String name);
    User selectById(Integer id);
    int updateUser(User user);
}
