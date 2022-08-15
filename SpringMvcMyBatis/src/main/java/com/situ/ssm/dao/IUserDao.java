package com.situ.ssm.dao;

import com.situ.ssm.pojo.User;
import com.sun.javafx.tk.TKPulseListener;

import java.util.Map;

public interface IUserDao {
    public User login(Map<String,Object> map);
    public User selectByName(String name);
    public int register(User user);
}
