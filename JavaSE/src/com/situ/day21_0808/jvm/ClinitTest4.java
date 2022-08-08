package com.situ.day21_0808.jvm;

public class ClinitTest4 {
    static{
        number = 20;
        // 报错，非法的前向引用 Illegal forward reference
        // 可以赋值但是不能调用
        // System.out.println(number);
    }

    // linking中prepare：number=0
    // initial: 20-->10
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClinitTest4.number);//10
    }
}
