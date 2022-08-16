package com.situ.spring.dao.impl;

import com.situ.spring.dao.IBanjiDao;
import org.springframework.stereotype.Repository;

@Repository
public class BanjiDaoImpl implements IBanjiDao {

    @Override
    public void selectAll() {
        System.out.println("BanjiDaoImpl.selectAll");
    }
}
