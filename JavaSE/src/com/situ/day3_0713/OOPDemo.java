package com.situ.day3_0713;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class OOPDemo {
    @Test
    public void test() {
//    student1:变量 、new出来对象、对象
//        Student student1 = new Student();
//        student1.id = 1;
//        student1.name = "zhangsan";
//        student1.age = 23;
//        student1.gender = "男";
//        System.out.println(student1.getInfo());
//        Student student2 = new Student();
//        student2.id = 2;
//        student2.name = "王五";
//        student2.age = 24;
//        student2.gender = "女";
//        System.out.println(student2.getInfo());
    }

    @Test
    public void test2() {
        Student student = new Student();
//        对象：方法
        student.setId(1);
        System.out.println(student.getId());
    }

    @Test
    public void test3() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("zhangsan");
        teacher.setAge(23);
        teacher.setSalary(10000);

        System.out.println(teacher.toString());
        System.out.println(teacher);
    }

    @Test
    public void test4() {
        // 局部变量必须要赋值
        int num = 0;
        System.out.println(num);
//        Variable 'teacher' might not have been initialized
        Teacher teacher = null;
//        java.lang.NullPointerException
//        null.属性  或者 null.方法()  就会报空指针异常
//        System.out.println(teacher.getName());

        Teacher teacher1 = new Teacher();
        System.out.println(teacher1.getName());//null
        System.out.println(teacher1.id);//0
    }

    @Test
    public void test7() {
        int[] array1 = new int[3];
        boolean[] array2 = new boolean[3];
        for (boolean bool : array2) {
            System.out.println(bool);
        }
        Student[] student = new Student[3];
        for (Student student1 : student) {
            System.out.println(student1);
        }
    }

    @Test
    public void test8() {

        Student student2 = new Student(1, "张三", 22, "男");
        System.out.println(student2);


    }

    /**************************作业********************************/
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        Number number1 = new Number(num1, num2);
        System.out.println(number1.add());
        System.out.println(number1.sub());
        System.out.println(number1.multi());
        System.out.println(number1.div());
    }

    @Test
    public void test6() {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.circumference());
        System.out.println(rectangle.area());
        Rectangle rectangle1 = new Rectangle(2);
        System.out.println(rectangle1.circumference());
        System.out.println(rectangle1.area());
        Rectangle rectangle2 = new Rectangle(1, 2);
        System.out.println(rectangle2.circumference());
        System.out.println(rectangle2.area());

    }
   /**********************************************************************/
}
