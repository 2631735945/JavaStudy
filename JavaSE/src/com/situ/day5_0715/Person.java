package com.situ.day5_0715;

import org.junit.jupiter.api.Test;

public class Person {

    //    静态代码块：在类加载时候执行静态代码块：只会执行一次
    static {
        System.out.println("Person.staic initializer");
    }

    //    实例初始化块 :每次调用构造方法之前首先调用实例初始化块
    {
        System.out.println("Person.instance initializer");

    }

    public Person() {
        System.out.println("Person person");
    }
}

