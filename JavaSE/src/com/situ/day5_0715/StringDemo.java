package com.situ.day5_0715;

import org.junit.jupiter.api.Test;

public class StringDemo {
    @Test
    public void test() {
//        "abc" :直接双引号括起来的字符串叫字符串常量，他也是一个对象
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc";
        System.out.println(str1 == str2);//false
        System.out.println(str2 == str3);//false
        System.out.println(str1 == str3);//true

        //比较字符串的内容是不是相等 equals()
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals(str2));//true

        String s1 = "Abc";
        String s2 = "aBc";
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//false
        //忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));//true
    }

    @Test
    public void test2() {
        String str = "java AndroidA";
        System.out.println(str.length());
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar + " ");//j a v a   A n d r o i d A
        }
        char c = str.charAt(5);
        System.out.println(c);//A
        int index = str.indexOf('A');
        System.out.println(index);//5
//        找不到返回-1
//        从fromindex开始往后找，输出A的索引
        System.out.println(str.indexOf('A', 6));//12
//        返回指定子字符串第一次出现的字符串内的索引。
        System.out.println(str.indexOf("And"));//5
//        返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。
        System.out.println(str.indexOf("And", 6));//-1
//        返回指定字符的最后一次出现的字符串中的索引。
        System.out.println(str.lastIndexOf('A'));//12
//      返回指定字符的最后一次出现的字符串中的索引，从指定的索引处开始进行反向搜索
        System.out.println(str.lastIndexOf('A', 11));//5
        System.out.println(str.lastIndexOf("And", 11));//5
    }

    @Test
    public void test3() {
        String str = "java AndroidA";

        System.out.println(str.contains("And"));//true
        System.out.println(str.startsWith("ja"));//true
//        offset    偏移到某个位置
        System.out.println(str.startsWith("And", 5));//true
        System.out.println(str.endsWith("idA"));//true
        System.out.println(str.isEmpty());//false
//        字符串常量也是对象
        System.out.println("abc".isEmpty());//false
        System.out.println("".isEmpty());//true

    }

    @Test
    public void test4() {
//        String str = "java AndroidA";
//        转换
        char[] array = {'j', 'a', 'v', 'a', ' ', 'A', 'n', 'd'};
        String str = new String(array);
        System.out.println(str);//java And
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar + ",");//j,a,v,a, ,A,n,d,
        }

    }

    @Test
    public void test5() {
        String str = "java AndroidA";
//        替换
        System.out.println(str.replace('A', 'B'));//java AndroidB
        System.out.println(str);//"java AndroidA"
    }

    @Test
    public void test6() {
        String str = "java Android python";
//        切割
        String[] arrays = str.split(" ");
        for (String array : arrays) {
            System.out.println(array);
        }
//        java
//        Android
//        python
    }

    //subtree substring
    @Test
    public void test7() {
        String str = "java AndroidA";
//        子串.获取字符串中的一部分
//         返回一个字符串，该字符串是此字符串的子字符串。
        System.out.println(str.substring(5));  //AndroidA
        System.out.println(str.substring(5, 8)); //And 前闭后开[5,8)

    }

    @Test
    public void test8() {
        String str = "   java AndroidA   ";
        System.out.println(str);//   java AndroidA
//        转换，去除空格，比较
//        返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        System.out.println(str.trim());//java AndroidA

    }



    @Test
    public void test10() {
        String str1 = "Java";
        String str2 = "php";
        String str3 = "C++";
        String str4 = "python";

        String str = str1 + str2 + str3 + str4;
        System.out.println(str);

        StringBuffer buffer = new StringBuffer("java");
        buffer.append("php");
        buffer.append("C++");
        buffer.append("python");
        System.out.println(buffer);
        String s = "java" + "php";

        StringBuilder builder = new StringBuilder("java");
//        append() 追加
        builder.append("php").append("C++").append("python");
//        链式结构 说明append 返回了当前的对象 return this;
    }

    @Test
    public void test11() {
        int num = 3;
        Integer integer = 3; //装箱
        //Integer integer1=new Integer(3);
        System.out.println(Integer.MAX_VALUE);
        int n = integer.intValue();
        Integer integer2 = integer + 2; //先拆箱再装箱
        System.out.println(integer2);
//        parse 解析
    }
    @Test
    public void test12() {
//        parse 解析
        String str="23";
        int num1=Integer.parseInt(str);
        System.out.println(num1);
        double num2=Double.parseDouble("3.14");
        System.out.println(num2);
        boolean num3=Boolean.parseBoolean("true");
        System.out.println(num3);

    }
}
