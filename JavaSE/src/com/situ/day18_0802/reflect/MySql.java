package com.situ.day18_0802.reflect;

public class MySql implements IDB{
    @Override
    public void getConnection() {
        System.out.println("MySql.getConnection");
    }
}
