package com.situ.day1_0711;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

//驼峰命名法
public class HelloWorld {
    //   快捷键
    //Shift+Enter 插入一行
    //Shift+alt+方向键 上下移动该行
    //    Alt+ Enter 快速修复一些错误
    //main

    //    JUnit: Java Unit 测试工具
//  explorer  资源管理器
    @Test
    public void aVoid() {
//  大小写敏感 case sensitive
        System.out.println("com.situ.day1.HelloWorld.aVoid");
    }

    @Test
    public void test2() {

        char ch = 'a';
        System.out.println(ch);//a

        System.out.println(ch + 1);  //97+1=98 从小到大 自动转换
        System.out.println(ch + 2);  //97+2=99从小到大 自动转换
        System.out.println((char) (ch + 1)); //b
        System.out.println((char) (ch + 2)); //c
        char num = (char) (ch + 1);
        System.out.println(num);//b
        double d = 3.14;
        int n = (int) d;
        System.out.println(n);//3
        long l1=10000000000L;
        int i1= (int) l1;
        System.out.println(i1);
    }

    @Test
    public void test4() {
        int num1 = 3;
        int num2 = 5;
        int result = num1 + num2;
        System.out.println(result); //8
        System.out.println(8 / 2);//4
        System.out.println(8 % 2);//0
        System.out.println(8 / 5);//1
        System.out.println(8 % 5);//3
    }

    @Test
    public void test5() {
        int i = 3;
        i++;
        System.out.println(i);//4
        System.out.println(i++);//4
        System.out.println(i);//5
        System.out.println(++i);//6
    }

    @Test
    public void test6() {
        System.out.println(3 > 5);//false
        System.out.println(5 <= 10);//true
    }

    @Test
    public void test7() {
        int score1 = 67;
        int score2 = 380;
        boolean result1 = (score1 >= 60) && (score2 >= 400);
        System.out.println(result1);//false
        boolean result2 = (score1 >= 60) || (score2 >= 400);
        System.out.println(result2);//true
    }

    @Test
    public void test8() {
        int num1 = 3;
        int num2 = 5;
//        &&短路
        System.out.println(num1 < 0 && num1++ < num2);//false
        System.out.println(num1);//3
        System.out.println(num2);//5
//        ||短路
        System.out.println(num1 > 0 || num1++ < num2);//true
        System.out.println(num1);//3
        System.out.println(num2);//5
    }

    @Test
    public void test9() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
//        卫操作 把非法输入和合法输入分开，非法输入直接在前面拦截
        if (score > 100 || score < 0) {
            System.out.println("非法输入");
            return;
        }
        if (score >= 90 && score <= 100) {
            System.out.println("优秀");
        } else if (score >= 80 && score < 90) {
            System.out.println("良好");
        } else if (score >= 70 && score < 80) {
            System.out.println("一般");
        } else if (score >= 60 && score < 70) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }

    //    语法：boolean ? 数1 ： 数2
    @Test
    public void test10() {
        int num1 = 3;
        int num2 = 5;
//        if (num1 > num2) {
//            System.out.println(num1);
//        } else {
//            System.out.println(num2);
//        }
//        ctrl +alt +v 创建返回值
        System.out.println(max(num1, num2));
        System.out.println(max1(num1, num2));
    }

    public int max(int num1, int num2) {
        int max = num1;
        if (num1 < num2) {
            max = num2;
        }
        return max;
    }

    @Test
    public int max1(int num1, int num2) {
        return (num1 >= num2) ? num1 : num2;

    }

    @Test
    public void test12() {
        int age = 23;
        System.out.println("我的年龄是" + age);
//        豆豆加加
        System.out.println("我的年龄是" + age + "岁了");
        System.out.println(10 + 20 + "" + 30);//3030
        System.out.println("" + 10 + 20 + 30);//102030

    }

    @Test
//    从控制台输入两个数,然后分别打印这两个数，然后交换这两个数的值
    public void test13() {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println(num1 + "   " + num2);
        double temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println(num1 + "   " + num2);

    }

    //    计算某年是不是闰年：
//            1、能被4整除，但是不能被100整除
//          ||
//            2、能被400整除
    @Test
    public void test14() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year <= 0) {
            System.out.println("违法输入，请输入正确的年份");
            return;
        }
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("该年份是闰年");
        } else {
            System.out.println("该年份不是闰年");

        }
    }

    @Test
    public void test15() {
        //    2、
//            2.1、编写一个收银台收款程序，if
//    定义输入----单价、数量、用户输入金额
//    定义输出----应收金额、找零
//    使用double类型变量 scanner.nextDouble();
//2.2、当总价>=500时候打八折
//2.3、考虑程序出现异常的情况，如：收款金额小于应收金额
//    若收款金额大于等于应收金额，则计算找零后输出
//    若收款金额小于应收金额，输出错误信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入单价");
        double unitPrice = scanner.nextDouble();
        System.out.println("请输入数量");
        double count = scanner.nextDouble();
        System.out.println("请输入用户金额");
//    用户输入金额
        double userInputAmount = scanner.nextDouble();
//    应收金额
        double totalPrice = unitPrice * count;

        if (userInputAmount < 0) {
            System.out.println("输入信息违法,请重新输入");
            while (userInputAmount < 0) {
                userInputAmount = scanner.nextDouble();
            }
        }
        while (userInputAmount >= 0) {

            if (userInputAmount < totalPrice) {
                System.out.println("付款金额不够,请重新输入付款金额 或者 输入0退出购买");
                userInputAmount = scanner.nextDouble();
                continue;
            }
            if (totalPrice > 0 && totalPrice < 500) {
                System.out.println("应收金额：" + totalPrice + "元" + "  " + "找零:" + (userInputAmount - totalPrice) + "元");
                break;
            } else if (totalPrice >= 500) {
                System.out.println("应收金额:" + (totalPrice * 0.8) + "元" + "  " + "找零:" + (userInputAmount - totalPrice * 0.8) + "元");
                break;
            }
        }

    }

    public static void main(String[] args) {
//ignore
        //main
        System.out.println("com.situ.day1.HelloWorld");
        //soutm  打印类名和方法名
        System.out.println("com.situ.day1.HelloWorld.main");

    }
}
