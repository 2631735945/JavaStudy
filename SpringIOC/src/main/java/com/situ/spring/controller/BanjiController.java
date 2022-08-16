package com.situ.spring.controller;

import com.situ.spring.service.IBanjiService;
import com.situ.spring.service.impl.BanjiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BanjiController {
    @Autowired
    @Qualifier(value="banjiServiceImpl2")
    private IBanjiService banjiService;

    public void  selectAll(){
        System.out.println("BanjiController.selectAll");
        banjiService.selectAll();
    }
}
