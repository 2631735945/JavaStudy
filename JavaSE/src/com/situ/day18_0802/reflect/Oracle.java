package com.situ.day18_0802.reflect;

public class Oracle implements IDB{
    @Override
    public void getConnection() {
        System.out.println("Oracle.getConnection");
    }
}