package com.situ.day21_0808.jvm;

public class ClinitTest3 {

    private static int number = 10;

    static {
        number = 20;
    }

    public static void main(String[] args) {
        System.out.println(ClinitTest3.number);//20
    }
}
