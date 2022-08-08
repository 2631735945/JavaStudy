package com.situ.day18_0802.reflect;

import com.situ.day18_0802.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    @Test
    public void test1() throws ClassNotFoundException {
        // 1、Class.forName("类路径")
        Class clazz1 = Class.forName("com.situ.day18_0802.Student");
        //2、类型.class
        Class clazz2 = Student.class;
        //3、对象.getClass();
        Student student = new Student();
        Class clazz3 = student.getClass();

        System.out.println(clazz2);
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz2 == clazz3);//true
        System.out.println(clazz1 == clazz3);//true
    }

    @Test
    public void testConstructor1() {
        Class clazz = Student.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    @Test
    public void testConstructor2() {
        Class clazz = Student.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
            System.out.println(constructor.getName());
            System.out.println(constructor.getModifiers());
        }
    }

    @Test
    public void testConstructor3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // Student student = new Student(1, "zhangsan", 23);
        Class clazz = Student.class;
        Constructor constructor = clazz.getDeclaredConstructor(Integer.class, String.class, Integer.class);
        // java.lang.IllegalAccessException:
        constructor.setAccessible(true);
        Student student = (Student) constructor.newInstance(1, "zhangsan", 23);
        System.out.println(student);

    }

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //Student student = new Student();
        //student.setName("lisi");

        Class clazz = Student.class;
//        默认构造函数，不需要获取构造函数，可直接实例
        Student student = (Student) clazz.newInstance();
        Method method = clazz.getMethod("setName", String.class);
        method.invoke(student, "lisi");
        System.out.println(student);
    }



}
