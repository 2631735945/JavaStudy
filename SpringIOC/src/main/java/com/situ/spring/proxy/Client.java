package com.situ.spring.proxy;

import com.situ.spring.service.ICourseService;
import com.situ.spring.service.impl.CourseServiceImpl;
import org.junit.Test;

public class Client {
    public static void main(String[] args) {
        DongShiZhang dongShiZhang=new DongShiZhang();
        IQianZi qianZi = new MiShu(dongShiZhang);
        qianZi.qianzi();
    }

    @Test
    public void test1(){
        DongShiZhang dongShiZhang=new DongShiZhang();
        IQianZi qianZi= (IQianZi) ProxyFactory.getProxyInstance(dongShiZhang);
        qianZi.qianzi();


        ICourseService courseService=new CourseServiceImpl();
        ICourseService proxy= (ICourseService) ProxyFactory.getProxyInstance(courseService);
        proxy.selectAll();
        proxy.deleteById(1);

    }
}

