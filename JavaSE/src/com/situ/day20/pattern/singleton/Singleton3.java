package com.situ.day20.pattern.singleton;

// 懒汉式
public class Singleton3 {
    private String name;
    // 可见性、禁止指令重排
    private volatile static Singleton3 INSTANCE;

    private Singleton3() {}

    // synchronized每次都要加锁，但是有线程安全问题只在第一次
    // 双重检查
    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            // 只在第一次INSTANCE==null时候有线程安全问题，才加锁
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}