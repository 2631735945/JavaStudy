package com.situ.ssm.service;

import com.situ.ssm.pojo.User;

import java.util.Map;

public interface IUserService {
    public User login(Map<String,Object> map);
    public User selectByName(String name);
    public int register(User user);
}
