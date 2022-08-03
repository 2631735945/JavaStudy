package com.situ.day18_0802.reflect;


public class SqlServer implements IDB{
    @Override
    public void getConnection() {
        System.out.println("SqlServer.getConnection");
    }
}