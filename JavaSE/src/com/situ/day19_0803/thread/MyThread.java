package com.situ.day19_0803.thread;

// Java是单继承，继承了Thread类，这个类就不能继承别的类
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
