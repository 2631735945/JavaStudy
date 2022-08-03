package com.situ.web.service.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.dao.IUserDao;
import com.situ.web.dao.impl.IUserDaoImpl;
import com.situ.web.pojo.User;
import com.situ.web.service.IUserService;
import com.situ.web.util.PageInfo;

import java.util.List;

public class IUserServiceImpl implements IUserService {
    private IUserDao userDao = new IUserDaoImpl();

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
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
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectByMsg(String name, String password) {
        return userDao.selectByMsg(name, password);
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }

    @Override
    public List<User> selectPage(Integer offset, Integer pageSize) {
        return userDao.selectPage(offset, pageSize);
    }

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {

        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);

        int offset = (pageNo - 1) * pageSize;
        List<User> list = userDao.selectPage(offset, pageSize);
        pageInfo.setList(list);
        int totalCount = userDao.selectCount();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);
        pageInfo.setTotalPages(totalPages);

        return pageInfo;
    }

    @Override
    public int update(User user) {
        return  userDao.update(user);
    }
}
