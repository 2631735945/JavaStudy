package com.situ.day3_0713.cal;

public abstract class Cal {
    protected int num1;
    protected int num2;

    public Cal() {
    }

    public Cal(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

//    public int getResult(){
//        return 0;
//
//    }
//    Abstract method in non-abstract class
//    如果一个类里面有抽象方法，那么这个类必须是抽象类
//    抽象方法更多是定义一个标准、规范，自己不提供实现，让子类实现
//    抽象类不能被实例化
    public abstract int getResult();
}
