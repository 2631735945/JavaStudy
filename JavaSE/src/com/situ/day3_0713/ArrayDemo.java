package com.situ.day3_0713;

import javafx.scene.control.Tab;
import org.junit.jupiter.api.Test;
import org.omg.PortableServer.ForwardRequest;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.Scanner;

public class ArrayDemo {
    @Test
    public void test() {
        int num = 3;
        int[] array = new int[4];
        array[0] = 24;
        array[1] = 23;
        array[2] = 3;
        array[3] = 4;

        System.out.println("length:" + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------------");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void test2() {
        int[] array1 = new int[3];
        double[] array2 = new double[3];
        array2[0] = 3.14;
        boolean[] array3 = new boolean[3];
        array3[0] = true;
        array3[1] = true;
        array3[2] = false;

        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
        for (int i = array3.length - 1; i >= 0; i--) {
            System.out.println(array3[i]);
        }
        int[] arr1 = {32, 5, 7, 87};
        int[] arr2 = new int[]{32, 5, 7, 87};
    }

    @Test
    public void test3() {
        int[] array = new int[4];
        array[0] = 24;
        array[1] = 23;
        array[2] = 3;
        array[3] = 4;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void test4() {
        int[] array = {32, 5, 7, 87};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    @Test
    public void test5() {
        int[] array = {40, 17, 21, 1};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int len = array.length;
        for (int end = len - 1; end >= 0; end--) {
            for (int second = 0; second <= end - 1; second++) {
                if (array[second] > array[second + 1]) {
                    swap(array, second, second + 1);
                }
            }
        }

    }

    //    bubbleSort2
    public void sort(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    // refactor
                    swap(array, j, j + 1);
                }
            }
        }
    }

    //交换函数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Test
    public void test6() {
        int[] scores = {0, 0, 1, 2, 3, 5, 4, 5, 2, 8, 7, 6, 9, 5, 4, 8, 3, 1, 0, 2, 4, 8, 7, 9, 5, 2, 1, 2, 3, 9};
        int[] count = new int[10];
        for (int i = 0; i < scores.length; i++) {
            count[scores[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }

    @Test
    public void test7() {
        int[] scores = {0, 0, 1, 2, 3, 5, 4, 5, 2, 8, 7, 6, 9, 5, 4, 8, 3, 1, 0, 2, 4, 8, 7, 9, 5, 2, 1, 2, 3, 9};
//        奇数数量
        int oddNumberCount = 0;
//        偶数数量
        int evenNmberCount = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] % 2 == 0) {
                evenNmberCount++;
            } else {
                oddNumberCount++;
            }
        }
        System.out.println("奇数数量：" + oddNumberCount + "   " + "偶数数量:" + evenNmberCount);
    }

    //    3、输入一组学生的成绩，使用数组，然后计算他们的平均值.
//    int[] scores = new int[3];
    @Test
    public void test8() {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[3];
        int AVGScore = 0;
        int totalScore = 0;
        System.out.println("请依次输入学生们的分数");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }
        AVGScore = totalScore / scores.length;
        System.out.println("平均分" + AVGScore);

    }

    //    题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
    @Test
    public void test9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据");
        int num = scanner.nextInt();
        if (judgePalindrome(num)) {
            System.out.println(num + "是回文数");
        } else {
            System.out.println(num + "不是回文数");
        }
    }

    //    判断回文数 palindrome
    public boolean judgePalindrome(int num) {
        boolean isPalindrome = false;
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return isPalindrome;
        }
        int temp = num;
        int newNum = 0;
        while (temp > 0) {
            newNum *= 10;
            newNum += temp % 10;
            temp /= 10;
        }
        if (num == newNum) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    public boolean judgePalindrome2(int num) {
        boolean isPalindrome = true;
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            isPalindrome=false;
            return isPalindrome;
        }
        String str = String.valueOf(num);
        int front = 0;
        int behind = str.length() - 1;
        while (front < behind) {
            if (str.charAt(front) == str.charAt(behind)) {
                front++;
                behind--;
            } else {
                isPalindrome = false;
                return isPalindrome;
            }
        }
        return isPalindrome;
    }


    //    17、输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
    @Test
    public void test10() {
        // char[] array = {'a' , 'b', 'c', 'b' , 'a'};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();// "abcba"
        System.out.println(str);
        int englishLetterCount = 0;
        int spaceCount = 0;
        int numberCount = 0;
        int otherLetterCount = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] <= 'Z')) {
                englishLetterCount++;
            } else if (array[i] == ' ') {  //""空字符串 可以为空  ''空字符 不可以为空,必须要有一个字符
                spaceCount++;
            } else if (array[i] >= '0' && array[i] <= '9') {
                numberCount++;
            } else {
                otherLetterCount++;
            }
        }
        System.out.println("英文字母个数：" + englishLetterCount + "  "
                + "空格个数：" + spaceCount + " " + "数字个数:" + numberCount + " "
                + "其它字符个数:" + otherLetterCount
        );
    }

    @Test
    public void test11() {
        double d = -0.5;
        System.out.println(Math.ceil(d));
        System.out.println(Math.floor(d));

    }
@Test
    public void test12(){
        int[] array={7,6,5,9,8,2};
        bubbleSort(array);
    for (int i : array) {
        System.out.println(i);
    }
}
public void bubbleSort1(int[] array){
        if(array==null||array.length<2){
            return;

        }      int len=array.length;
        for(int end=len-1;end>=0;end--){
            for(int j=0;j<=end-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
}


   @Test
    public void test111(){
      int[] array=new int[]{1,2,9,5,8,6,5};
       for (int arr : array) {
           System.out.println(arr);
       }

   }
}
