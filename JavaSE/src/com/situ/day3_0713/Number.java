package com.situ.day3_0713;

public class Number {
    private int num1;
    private int num2;

    public Number(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Number() {
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return this.num1 + this.num2;
    }

    public int sub() {
        return this.num1 - this.num2;
    }

    public int multi() {
        return this.num1 * this.num2;
    }

    public String div() {
        String str = " ";

        if (num2 != 0) {
            str = this.num1 / this.num2 + " ";

        } else {
            str = "数据异常除数不能为0";
        }
        return str;
    }
}
