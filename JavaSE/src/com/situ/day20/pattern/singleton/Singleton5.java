package com.situ.day20.pattern.singleton;

// 内部类懒汉式
//
public class Singleton5 {
    // static Singleton5 INSTANCE = new Singleton5();
    private Singleton5() {}

    // Holder内部类
    private static class Holder {
        // JVM线程安全
        static Singleton5 INSTANCE = new Singleton5();
    }

    public Singleton5 getInstance() {
        return Holder.INSTANCE;
    }
}
