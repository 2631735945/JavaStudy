package com.situ.day19_0803.thread.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        boolean bool1 = atomicInteger.compareAndSet(2020, 2022);
        System.out.println(bool1);// true
        System.out.println(atomicInteger.get());// 2022
        boolean bool2 = atomicInteger.compareAndSet(2020, 2023);
        System.out.println(bool2);// true
    }
    @Test
    public void test1() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.getAndIncrement());//0 i++
        System.out.println(atomicInteger.incrementAndGet());//2 ++i
    }
}
