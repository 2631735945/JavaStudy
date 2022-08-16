package com.situ.spring.service.impl;

import com.situ.spring.dao.IBanjiDao;
import com.situ.spring.service.IBanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanjiServiceImpl2 implements IBanjiService {
    @Autowired
    private IBanjiDao banjiDao;
    @Override
    public void selectAll() {
        System.out.println("BanjiServiceImpl.selectAll");
        banjiDao.selectAll();
    }
}
