package com.situ.day5_0715;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class HomeWork {
    @Test
    public void test() {

        System.out.println("请输入字符串");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        System.out.println(testTirm(str));

    }

    public String testTirm(String str) {
        int start = 0;
        int end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                start++;
            } else {
                break;
            }
        }
        if (start == str.length()) {
            return "这是个空白串";
        }

        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == ' ') {
                end--;
            } else {
                break;
            }
        }
        if (end == -1) {
            return "这是个空白串";
        }
        String subString = str.substring(start, end+1);
        return subString;
    }

    @Test
    public void test2() {
//        char a='A';
//       char b= (char) (a+32);
//        System.out.println(a);
        System.out.println("请输入字符串");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        System.out.println(testToUpper(str));
        System.out.println(testToLower(str));
    }

    public String testToLower(String str) {

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] + 32);
            }
        }
        String toLowerString = new String(ch);
        return toLowerString;
    }

    public String testToUpper(String str) {

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char) (ch[i] - 32);
            }
        }
        String toUpperString = new String(ch);
        return toUpperString;
    }

    @Test
    public void test3() {
        // java.lang.StringIndexOutOfBoundsException: String index out of range: 6
        // 极端情况：边界
        // String str = "---java Android---";
        String str = "";
        String newStr = trim(str);
        System.out.println(newStr);
    }

    public String trim(String str) {
        // 卫操作
        int beginIndex = 0;
        int endIndex = str.length() - 1;
        while ((beginIndex <= endIndex) && (str.charAt(beginIndex) == '-')) {
            beginIndex++;
        }
        while ((beginIndex <= endIndex) && (str.charAt(endIndex) == '-')) {
            endIndex--;
        }

        return str.substring(beginIndex, endIndex + 1);
    }

    @Test
    public void test4() {
        String str = "I love Java";
        String newStr = toUpperCase(str);
        System.out.println(newStr);
    }

    public String toUpperCase(String str) {
        char[] chars = str.toCharArray();
        char[] newArray = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            newArray[i] = ch;
        }

        return new String(newArray);
    }

    public String tirm1(String str) {
        int stratIndex = 0;
        int endIndex = str.length()-1;
        for (int i = 0; i <= endIndex; i++) {
            if (str.charAt(i) == ' ') {
                stratIndex++;
            } else {
                break;
            }
        }
        if (stratIndex == str.length()) {
            return "这是一个空白串";
        }
        for (int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==' '){
                endIndex--;
            }else {
                break;
            }
        }


    return  str.substring(stratIndex,endIndex+1);
    }

    public String Tirm2(String str){
        int beginIndex=0;
        int endIndex=str.length()-1;
        while((beginIndex<=endIndex)&& str.charAt(beginIndex)==' '){
            beginIndex++;
        }
        if(beginIndex>endIndex){
            return "这是一个空白串";

        }
        while((beginIndex<=endIndex)&& str.charAt(endIndex)==' '){
            endIndex--;
        }
        return str.substring(beginIndex,endIndex+1);
    }

}
