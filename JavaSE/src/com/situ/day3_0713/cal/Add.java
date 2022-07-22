package com.situ.day3_0713.cal;

public class Add extends Cal{

    public Add() {
        super();
    }

    public Add(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1+num2;
    }

    //    实例方法
//    @Override
//    public int getResult() {
////        super：父类对象
////        this: 当前类的对象
////        this(): new当前类的其它构造方法
////        super():父类的构造方法
////        return super.getResult();
//        return num1+num2;
//    }
}
