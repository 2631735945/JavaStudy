package com.situ.day4_0714;

import org.junit.jupiter.api.Test;

public class OOPDemo {
    @Test
    public void test1(){
//        Hex 十六进制  十进制 decimal
        Student student1=new Student(1,"张三",23,"java220702");
        System.out.println(student1);
        System.out.println(student1.toString());
        Student student2 = new Student();
        student2.setId(1);
        student2.setName("zhangsan");
        student2.setClassName("Java2207");

    }}
