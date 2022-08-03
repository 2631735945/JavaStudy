package com.situ.web.service.impl;

import com.situ.web.dao.impl.layUserDaoImpl;
import com.situ.web.dao.layUserDao;
import com.situ.web.pojo.User;
import com.situ.web.service.layUserService;
import com.situ.web.util.JSONUtil;
import com.situ.web.util.LayUITableJSONResult;

import java.util.List;

public class layUserServiceImpl implements layUserService {

    private layUserDao userDao=new layUserDaoImpl();

    @Override
    public List<User> selectPage(Integer offset, Integer limit) {
        return userDao.selectPage(offset,limit);
    }

    @Override
    public int selectTotalCount() {
        return userDao.selectTotalCount();
    }

    @Override
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
       int offset=(page-1)*limit;
        List<User> list= userDao.selectPage(offset,limit);
        int count= userDao.selectTotalCount();
        return LayUITableJSONResult.ok(count,list);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int deleteAll(String[] ids) {
        int sum=0;
        for (String id : ids) {
            int count=userDao.deleteById(Integer.parseInt(id));
            if(count>0){
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }

    @Override
    public int add(User user, String name) {
        User user1 = selectByName(name);
        System.out.println(user1);
        if (user1 == null) {
            return userDao.add(user, name);
        }
        return 0;
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
