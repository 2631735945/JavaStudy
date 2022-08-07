package com.situ.day19_0803.thread.producerconsumer;


import java.util.Random;

public class ProducerThread extends Thread{
    private Panzi panzi;

    public ProducerThread(String name, Panzi panzi) {
        super(name);
        this.panzi = panzi;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            Cake cake = new Cake("no:" + i);
            panzi.putCake(cake);
            System.out.println(Thread.currentThread().getName() + " getCake: " + cake);

            // 等待的时间是随机的，模拟生产蛋糕时间
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
