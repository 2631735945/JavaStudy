package com.situ.spring.test;

import com.situ.spring.controller.StudentController;
import com.situ.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Springtest {
    @Test
    public void test1(){
        // 创建Spring容器，在xml中配置的bean都会new出对象放到Spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //单例模式下，加载文件的时候就把对象new出来了，并放在容器中，而不是调用getBean的时候new的
        //从Spring容器中根据名字取出指定new出来的对象
        Student student= (Student) context.getBean("student1");
        System.out.println(student);


    }
    public void test2(){
        // 创建Spring容器，在xml中配置的bean都会new出对象放到Spring容器
//        单例模式下对象会在加载文件的时候new出来，并放在容器中，
//        多例模式下加载文件的时候不会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从Spring容器中根据名字取出指定new出来的对象
        //Student student1 = (Student) context.getBean("student");
        //Student student2 = (Student) context.getBean("student");
        //System.out.println(student1 == student2); 单例模式下返回true，多例模式下返回false


    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController= (StudentController) context.getBean("studentController");
        studentController.selectAll();

    }}
