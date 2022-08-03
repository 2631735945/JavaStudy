package com.situ.day19_0803.thread.producerconsumer;


import java.util.LinkedList;

/*
核心的资源类
 */
public class Panzi extends Object{
    // 使用LinkedList来模拟队列的结构，队列的尾部添加，队列的头部移除
    private LinkedList<Cake> list = new LinkedList();

    // 这个盘子无限大   如果限定盘子10个
    public synchronized void putCake(Cake cake) {
        if (list.size() >= 2) {
            try {
                System.out.println("生产者线程 putCake wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.addLast(cake);
        this.notifyAll();
    }

    public synchronized Cake getCake() {
        if (list.size() <= 0) {
            // 盘子里面没有蛋糕了，就需要等待生产者生产蛋糕
            try {
                System.out.println("消费者线程 getCake wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Cake cake = list.removeFirst();
        notifyAll();
        return cake;
    }
}
