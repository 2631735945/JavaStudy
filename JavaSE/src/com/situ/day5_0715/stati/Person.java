package com.situ.day5_0715.stati;

public class Person {

    private static User1 user1 = new User1();
    private User2 user2 = new User2();

    // 静态代码块:在类加载时候执行静态代码块，只会执行一次
    static {
        System.out.println("Person.static initializer");
    }

    // 实例初始化块，每次调用构造方法之前首先调用实例初始化块
    {
        System.out.println("Person.instance initializer");
    }

    public Person() {
        System.out.println("Person.Person");
    }
}

