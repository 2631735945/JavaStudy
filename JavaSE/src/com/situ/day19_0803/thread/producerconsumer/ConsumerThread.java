package com.situ.day19_0803.thread.producerconsumer;

import java.util.Random;

public class ConsumerThread extends Thread{
    private Panzi panzi;

    public ConsumerThread(String name, Panzi panzi) {
        super(name);
        this.panzi = panzi;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            Cake cake = panzi.getCake();
            System.out.println(Thread.currentThread().getName() + " putCake: " + cake);

            // 等待的时间是随机的，模拟吃蛋糕时间
            try {
                //这里是为了验证join()方法 所以给消费者进程加了随机等待时间
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
