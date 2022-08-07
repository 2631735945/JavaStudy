package com.situ.day19_0803.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncSaleTicket {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();

        // 多个线程同时访问同一个资源，把资源放入线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "b").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "c").start();
    }
}

// 资源类
class Ticket1 {
    private int ticketNum = 30;

    // 卖票 synchronized 加锁
    public synchronized void sale() {
        if (this.ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "购得第" + ticketNum-- + "张票, 剩余" + ticketNum + "张票");

            //增加错误的发生几率
           /* try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
