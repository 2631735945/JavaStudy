package com.situ.day20.pattern;

public class RecursionDemo {
    //private static int count = 0;

    // java.lang.StackOverflowError
    public static void main1(String[] args) {
        fun();
    }

    public static void fun() {
        //System.out.println("count: " + ++count);
        fun();
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }

    // factorial
    // 5!=5*4*3*2*1
    // factorial(5)=5*factorial(4)
    // factorial(4)=4*factorial(3)
    // factorial(3)=3*factorial(2)
    // factorial(2)=2*factorial(1)
    // factorial(1)=1
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        /*if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }*/
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
