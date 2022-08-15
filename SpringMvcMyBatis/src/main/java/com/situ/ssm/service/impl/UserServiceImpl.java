package com.situ.ssm.service.impl;

import com.situ.ssm.dao.IUserDao;
import com.situ.ssm.dao.impl.UserDaoImpl;
import com.situ.ssm.pojo.User;
import com.situ.ssm.service.IUserService;

import java.util.Map;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao=new UserDaoImpl();

    @Override
    public User login(Map<String, Object> map) {
        return userDao.login(map);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public int register(User user) {
        System.out.println("UserServiceImpl.register");
        System.out.println(user);
        User user1=selectByName(user.getName());
        if(user1==null){
            return userDao.register(user);
        }
        return 0;

    }
}
