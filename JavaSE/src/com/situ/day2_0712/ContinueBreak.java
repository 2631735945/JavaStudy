package com.situ.day2_0712;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ContinueBreak {
    @Test
//    例题：随机生成一个整数1-1000
//    用户输入一个整数，程序给出与存储的数字是“大”或者“小”，知道用户猜到这个数字位置。
    public void test5() {
        Scanner scanner = new Scanner(System.in);
//        int random=new Random().nextInt(1000)+1;

//        double greater than or equal to 0.0 and less than 1.0.
//       [0.0,1.0)*1000
//       [0.0,1000.0)+1=(int)[1.0,1000.0]=[1,1000]
        int random = (int) (Math.random() * 1000 + 1);
        System.out.println(random);
        System.out.println("输入0退出");
        System.out.println("开始猜吧");
        while (true) {
            int guess = scanner.nextInt();
            if (guess < 0 || guess > 1000) {
                System.out.println("请输入0~1000范围内的数据");
                continue;
            }
            if (guess == 0) {
                System.out.println("已退出");
                break;
            }
            if (random > guess) {
                System.out.println("太小了");
                System.out.println("猜吧");
                continue;

            } else if (random < guess) {
                System.out.println("太大了");
                System.out.println("猜吧");
                continue;
            } else if (random == guess) {
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }

    @Test
    public void test1() {
        for (int i = 1; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        for (int i = 1; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("i:" + i);
            for (int j = 1; j < 10; j++) {
                if (j == 5) {
                    break;
                }
                System.out.println("j:" + j);
            }
        }

    }

    //    1、
//            ****
//            ****
//            ****
    @Test
    public void test4() {
        for (int i = 1; i <= 3; i++) {
//            外层循环 代表行
//            内层循环  代表列
            for (int j = 1; j <= 4; j++) {
                System.out.print("*");
//                   if (j==4){
//                       System.out.println();
//                   }
            }
            System.out.println();
        }
    }

    //2、
//        *
//        **
//        ***
//        ****
//        *****
    @Test
    public void test7() {
        for (int i = 1; i <= 5; i++) {
//            外层循环 代表行
//            内层循环  代表列
            for (int j = 1; j <= 5; j++) {
                if (i == j) {
                    System.out.print("*");
                    break;
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void test9() {
        for (int i = 1; i <= 5; i++) {
//            外层循环 代表行
//            内层循环  代表列
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test8() {
        for (int i = 1; i <= 9; i++) {
//            外层循环 代表行
//            内层循环  代表列
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + " ");

            }
            System.out.println();
        }
    }

    @Test
    public void test10() {
//        double greater than or equal to 0.0 and less than 1.0.
//       [0.0,1.0)*1000
//       [0.0,1000.0)+1=(int)[1.0,1000.0]=[1,1000]
        int random = (int) (Math.random() * 1000 + 1);
        System.out.println(random);

    }
}
