package com.situ.day21_0808.jvm;

public class ClassLoaderPath {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
