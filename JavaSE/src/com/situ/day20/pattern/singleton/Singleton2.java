package com.situ.day20.pattern.singleton;

// 懒汉式
public class Singleton2 {
    private static Singleton2 INSTANCE;
    private Object lock = new Object();

    private  Singleton2() {}

    // Singleton2.class
    // 线程安全问题：多个线程同时修改共享数据
    // this
    public synchronized static Singleton2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}
