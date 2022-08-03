package com.situ.web.service.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.dao.impl.ITeacherDaoImpl;
import com.situ.web.pojo.Teacher;
import com.situ.web.service.ITeacherService;
import com.situ.web.util.PageInfo;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

public class ITeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao = new ITeacherDaoImpl();

    @Override
    public List<Teacher> selectPage(Integer offset, Integer pageSize) {
        return teacherDao.selectPage(offset, pageSize);
    }

    @Override
    public int selectCount() {
        return teacherDao.selectCount();
    }

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        PageInfo<Teacher> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);

        int offset = (pageNo - 1) * pageSize;
        List<Teacher> list = teacherDao.selectPage(offset, pageSize);
        pageInfo.setList(list);
        int totalCount = teacherDao.selectCount();
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        pageInfo.setTotalPages(totalPage);

        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
       return teacherDao.deleteById(id);
    }

    @Override
    public void add(Teacher teacher) {
        teacherDao.add(teacher);
    }

    @Override
    public Teacher selectById(Integer id) {
        return teacherDao.selectById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }
}
