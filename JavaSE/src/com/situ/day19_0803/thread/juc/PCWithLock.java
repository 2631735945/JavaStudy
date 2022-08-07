package com.situ.day19_0803.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCWithLock {
    public static void main(String[] args) {
        DataLock data = new DataLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        data.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Inc1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        data.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Inc2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        data.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Dec1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        data.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Dec2").start();

    }
}

class DataLock{
    //属性
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1方法
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number == 1){
                // 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "--->" + number);
            // 加完之后通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //-1
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0){
                // 等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "--->" + number);
            // 减完之后通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
