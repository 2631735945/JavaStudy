package com.situ.day20.pattern.singleton;

// 饿汉式
public class Singleton1 {
    //缺点类加载时候就要new出对象
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
