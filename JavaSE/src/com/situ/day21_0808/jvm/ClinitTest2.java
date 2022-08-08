package com.situ.day21_0808.jvm;

public class ClinitTest2 {
    // prepare: num = 0 ---> initial: num = 2;
    private static int num = 2;


    public static void main(String[] args) {
        System.out.println(num);// 2
    }
}
