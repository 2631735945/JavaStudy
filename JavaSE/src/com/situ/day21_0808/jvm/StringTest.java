package com.situ.day21_0808.jvm;

public class StringTest {
    public static void main(String[] args) {
        String str = new String();
        System.out.println("hello jvm");

        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
