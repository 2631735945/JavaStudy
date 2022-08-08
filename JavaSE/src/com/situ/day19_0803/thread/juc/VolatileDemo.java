package com.situ.day19_0803.thread.juc;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    private static volatile int num = 0;

    public static void main(String[] args) { // main
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num == 0){

                }
            }
        }).start();

        // Thread.sleep(1000);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
//        不加volatile的时候  程序不会中断，会陷入死循环，因为num变为1的时候
//        Thread进程不知道，一直以为run还是零，然后就一直执行
//        加了volatile后，因为它有可见性，那么num变为1了之后， Thread进程也知道了，然后就结束循环
    }
}
