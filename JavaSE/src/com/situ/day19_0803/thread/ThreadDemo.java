package com.situ.day19_0803.thread;


public class ThreadDemo {

    public static void main4(String[] args) {
        // 匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    public static void main3(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "myRunnable");
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadDemo.main");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        // 这不是启动一个线程，这是不同的方法调用
        //myThread.run();
        // 真正启动线程调用start方法，执行的代码就是run方法里面代码
        myThread.start();
    }


    public static void main1(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());// main
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
