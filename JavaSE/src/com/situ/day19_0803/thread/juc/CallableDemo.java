package com.situ.day19_0803.thread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask, "CallableDemo");
        thread.start();
        String str = futureTask.get();
        System.out.println(str);
        System.out.println("CallableDemo.main");
    }
}

class MyCallable implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("MyCallable.call");
        Thread.sleep(5000);
        return "abc";
    }
}
