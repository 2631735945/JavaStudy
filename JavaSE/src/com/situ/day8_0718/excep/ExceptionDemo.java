package com.situ.day8_0718.excep;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//execute执行
public class ExceptionDemo {
    @Test
    public  void test1(){
        String str="hello";
        char ch1=str.charAt(4);
        System.out.println(ch1);
//        java.lang.StringIndexOutOfBoundsException: String index out of range: 5
//        char ch2=str.charAt(5);
//        System.out.println(ch2);
//        java.lang.ArithmeticException: / by zero   算数异常
        int i=1;
        System.out.println(i/0);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        fun();
    }
    // throws ClassNotFoundException
//fun方法调用Class.forName抛出异常，fun如果不想处理这个异常
    public void fun() throws ClassNotFoundException {
        //   // javac 编译时异常  ClassNotFoundException
        Class.forName("com.mysql.jdbc.Drive");
//        Signature 签名

    }
    @Test
    public void test4()  {
//      // javac 编译时异常  ClassNotFoundException
        try {
            Class.forName("com.mysql.jdbc.Drive");
            // 获得连接
            try {
                Connection connection = DriverManager.getConnection("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 不管抛不抛出异常，finally中代码一定会执行
        }
        // 上面捕获异常之后，程序会继续往下执行
        System.out.println("ExceptionDemo.test4");

    }

    @Test
    public void test5(){
        try {
            FileInputStream fileInputStream=new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager(1000.0);
        accountManager.deposit(500.0);
        try {
            accountManager.withdraw(1600.0);
        } catch (MeiQianException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

}
