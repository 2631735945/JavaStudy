package com.situ.day19_0803.thread.juc.volatil;

// 可见性例子
// -Xint
public class ForeverLoop {
    static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println("modify stop to true...");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stop);
        }).start();

        foo();
    }

    static void foo() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("stopped... c:" + i);
    }
}
