package com.situ.day2_0712;

import org.junit.jupiter.api.Test;
import sun.print.SunMinMaxPage;

import java.util.Random;
import java.util.Scanner;

public class WhileForSwitch {
    @Test
    public void test1() {

//       1. 循环条件的初始化
        int i = 1;
//        2、循环条件的控制
        while (i <= 5) {
            System.out.println("HelloWorld");
//            3、循环条件的改变
            i++;
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("hello world");
        }
    }

    @Test
//1.累加思想(1+2+3+...+100)
    public void test3() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
//2、统计思想，数一下符合条件的有多少个（计算1-100以内7的倍数的个数）
    public void test4() {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 通过传入的年份判断是不是闰年
     *
     * @param year 要判断的年份
     * @return true:是闰年，false：不是闰年
     */
    @Test
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Test
    public void test5() {
//    输入月份、年份判断天数：
//    1、3、5、7、8、10、12  -------- 31天
//    4、6 、9、11--------------------30天
//    2----------------------------------28/29天
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入月份");
        int month = scanner.nextInt();
        int year = 0;
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                System.out.println(month + "月份共有：" + day + "天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                System.out.println(month + "月份共有：" + day + "天");
                break;
            case 2:
                System.out.println("输入年份");
                year = scanner.nextInt();
                if (isLeapYear(year)) {
                    day = 29;
                    System.out.println(year + "是闰年" + month + "月份有：" + day + "天");
                } else {
                    day = 28;
                    System.out.println(year + "不是闰年" + month + "月份有：" + day + "天");
                }
                break;
            default:
                System.out.println("违法输入");
        }

    }


    //   >=90   <=100   优秀
//   >=80    <90       良好
//   >=70    <80       一般
//   >=60    <70      及格
//   <60                    不及格
    @Test
    public void test6() {
        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();
        if (score < 0 || score > 100) {
            System.out.println("非法输入");
            return;
        }
        int grade = (int) (score / 10);
        switch (grade) {
            case 10:
            case 9:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("一般");
                break;
            case 6:
                System.out.println("及格");
                break;
            default:
                System.out.println("不及格");
        }
    }

    //    1、输出一下结构：
//        1
//        12
//        123
//        1234
//        12345
    @Test
    public void test7() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //    打印正三角形和倒三角形
//                  *
//                 ***
//                 *****
//                 *******
//                 *********
//                 ***********
    @Test
    public void test8() {
//        正三角
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 11; j++) {
                if (j >= (11 / 2 + 1) - (i - 1) && j <= (11 / 2 + 1) + (i - 1)) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
//        倒三角
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 11; j++) {
                if (j >= i && j <= 11 - (i - 1)) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }

    // -----*
// ----***
// ---*****
// --*******
// -*********
// ***********
    @Test
    public void test13() {
        for (int i = 1; i <= 6; i++) {
            // i=1  j=5
            // i=2  j=4
            // i=3  j=3
            // i=4  j=2
            // i=5  j=1
            // i=6  j=0
            for (int k = 1; k <= (6 - i); k++) {
                System.out.print(" " + " ");
            }
            // i=1  j=1
            // i=2  j=3
            // i=3  j=5
            // i=4  j=7
            // j=2*i-1
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();

        }
    }

    //    3、计算1-100以内所有奇数的和以及所有偶数的和，分别打印出来。
    @Test
    public void test9() {
//        奇数和
        int oddNumberNum = 0;
//        偶数和
        int evenNmberNum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenNmberNum += i;
            } else {
                oddNumberNum += i;
            }
        }
        System.out.println("奇数和:" + oddNumberNum + "  " + "偶数和:" + evenNmberNum);
    }

    //    4、用for循环输出1—1000之间能被5整除的数，且每行输出3个
    @Test
    public void test10() {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 5 == 0) {
                System.out.print(i + " ");
                count++;
//                if (count == 3) {
//                    System.out.println();
//                    count = 0;
//                }
                if (count % 3 == 0) {
                    System.out.println();
                }
            }
        }
    }

    //    5、计算9的阶乘
    @Test
    public void test11() {
        int num = 1;
        for (int i = 1; i <= 9; i++) {
            num *= i;
        }
        System.out.println(num);
    }

    //    6、使用循环打印100-200之间所有的素数（只能被1和自己整除的数叫素数）
    @Test
    public void test12() {

        for (int i = 100; i <= 200; i++) {
            boolean isTrue = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                System.out.println(i);
            }
        }
    }

    // -----*
// ----***
// ---*****
// --*******
// -*********
// ***********
    @Test
    public void test14() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= (6 - i); j++) {
                System.out.print(" " + " ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void test15(){
        int[] array={1,5,0,3,9};
        bubbleSort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    //    冒泡排序
    public void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int len = array.length;
        for (int end = len - 1; end >= 0; end--) {
            for (int second = 0; second <= end - 1; second++) {
                if(array[second]>array[second+1]){
                    swap(array,second,second+1);
                }
            }
        }
    }    //    冒泡排序
    public void bubbleSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int len = array.length;
        for(int i=0;i<=array.length-i;i++){
            for(int j=1;j<=array.length-1-i;j++){
                if(array[j-1]> array[j]){
                    swap(array,j-1,j);
                }
            }
        }    }

    //    交换函数
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
