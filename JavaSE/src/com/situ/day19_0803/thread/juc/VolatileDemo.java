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
    }
}
