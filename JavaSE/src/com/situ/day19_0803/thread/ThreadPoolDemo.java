package com.situ.day19_0803.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 一池5线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池一线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 一池可扩容线程
        // ExecutorService threadPool = Executors.newCachedThreadPool();

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 1; i <=10; i++) {
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "为第"+index+"个任务服务");
                }
            });
        }
    }
}
